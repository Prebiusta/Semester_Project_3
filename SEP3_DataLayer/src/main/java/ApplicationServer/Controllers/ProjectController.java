package ApplicationServer.Controllers;

import ApplicationServer.JPA.AdministratorsInProjectsRepository;
import ApplicationServer.JPA.ProjectRepository;
import ApplicationServer.JPA.SprintRepository;
import ApplicationServer.JPA.UsersInProjectsRepository;
import ApplicationServer.Model.AdministratorsInProjects;
import ApplicationServer.Model.CompositeKeys.AdministratorProjectKey;
import ApplicationServer.Model.CompositeKeys.UserProjectKey;
import ApplicationServer.Model.Project;
import ApplicationServer.Model.Sprint;
import ApplicationServer.Model.UsersInProjects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ProjectController {
    private ProjectRepository projectRepository;
    private UsersInProjectsRepository usersInProjectsRepository;
    private AdministratorsInProjectsRepository administratorsInProjectsRepository;
    private SprintRepository sprintRepository;

    public ProjectController(ProjectRepository projectRepository, UsersInProjectsRepository usersInProjectsRepository, AdministratorsInProjectsRepository administratorsInProjectsRepository, SprintRepository sprintRepository) {
        this.projectRepository = projectRepository;
        this.usersInProjectsRepository = usersInProjectsRepository;
        this.administratorsInProjectsRepository = administratorsInProjectsRepository;
        this.sprintRepository = sprintRepository;
    }

    /**
     * Add new entry to UsersInProjects table. Takes project id nad username to create new row.
     * EXAMPLE:
     *  http://{host}:6969/api/addUser?projectId=8&username=David
     *
     * @param projectId id of the project
     * @param username username of the user to add to the project
     * @return <i>HTTP 201 - CREATED</i> code with saved object in body if user is added to the project. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<?> addUserToProject(
            @RequestParam(value = "projectId", required = false) Integer projectId,
            @RequestParam(value = "username", required = false) String username){
        try {
            UsersInProjects entry = new UsersInProjects(new UserProjectKey(username, projectId));
            var responseFromDb = usersInProjectsRepository.save(entry);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseFromDb);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Finds all projects by status, specific one by project ID or all projects for user.
     *
     * EXAMPLE:
     *  http://{host}:8080/api/project?status=completed
     *
     * @param status status of the project (ongoing/completed).
     * @param id id of the project.
     * @param username unique username to get all relevant projects.
     * @return <i>HTTP 200 - OK</i> code if project/projects were returned with List of projects as a body. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public ResponseEntity<?> getProject(
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "username", required = false) String username) {
        if (status != null) {
            return ResponseEntity.status(HttpStatus.OK).body(projectRepository.findAllByStatus(status));
        } else if (id != null) {
            return ResponseEntity.status(HttpStatus.OK).body(projectRepository.findByProjectId(id));
        } else if (username != null) {
            return ResponseEntity.status(HttpStatus.OK).body(projectsForUser(username));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not allowed to get all database Projects");
    }

    /**
     * Method for creating a new project. Processing data in JSON form sent from client site of the system.
     * Creates a project and saves it to the database.
     * If the project was created successfully it returns  a HTTP Response Status with code '200 OK'
     * If the project failed to be created  it returns  a HTTP Response Status with code '400 Bad Request'
     *
     * Example:
     *  POST METHOD: http://{host}:6969/api/project?username={existing username}
     *  BODY:
     *
     *     {
     * 	    "name": "{Project name}",
     * 	    "status": "completed / ongoing",
     * 	    "numberOfIterations": {integer},
     * 	    "lengthOfSprint": {integer}
     *     }
     *
     * @param project Project object in format of Json received from client
     * @param username Name of the user who created the project so he will automatically be assigned as an administrator.
     * @return <i>HTTP 200 - OK</i> code if project created. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public ResponseEntity<String> create(
            @RequestBody Project project,
            @RequestParam(value = "username") String username) {
        Project savedProject = projectRepository.save(project);
        if (savedProject != null) {
            AdministratorsInProjects adminEntry = new AdministratorsInProjects(new AdministratorProjectKey(username, savedProject.getProjectId()));
            UsersInProjects userEntry = new UsersInProjects((new UserProjectKey(username, savedProject.getProjectId())));
            try {
                administratorsInProjectsRepository.save(adminEntry);
                usersInProjectsRepository.save(userEntry);

                // Create all Sprints for Project based on number of iterations. Some variables are null and have
                // to be initialized during sprint planning.
                for (int a = 0; a < project.getNumberOfIterations(); a++){
                    Sprint sprint = new Sprint(project.getProjectId(), a + 1);
                    sprintRepository.save(sprint);
                }
                return ResponseEntity.status(HttpStatus.OK).body("Project created");
            } catch (Exception e){
                projectRepository.delete(savedProject);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }
        // If anything above goes wrong
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Creation of the Project failed");
    }

    private List<?> projectsForUser(String username) {
        List<UsersInProjects> projectIds = usersInProjectsRepository.findByUserProjectKeyUsername(username);

        List<Project> projectList = new ArrayList<>();

        // Loop through all UsersInProject entries and find all Projects with given IDs
        for (UsersInProjects usersInProjects : projectIds) {
            var project = projectRepository.findByProjectId(usersInProjects.getUserProjectKey().getProjectId()).get(0);
            var administratorsInProject = administratorsInProjectsRepository.findByAdministratorProjectKeyProjectId(project.getProjectId());

            List<String> administratorUsername = new ArrayList<>();

            for (AdministratorsInProjects admin : administratorsInProject){
                administratorUsername.add(admin.getAdministratorProjectKey().getUsername());
            }

            // Using custom constructor to notify Business Logic Server who is an administrator of every project.
            projectList.add(new Project(project, administratorUsername));
        }

        return projectList;
    }

}