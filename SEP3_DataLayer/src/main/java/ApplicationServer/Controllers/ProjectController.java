package ApplicationServer.Controllers;

import ApplicationServer.JPA.ProjectRepository;
import ApplicationServer.JPA.SprintRepository;
import ApplicationServer.JPA.UsersInProjectsRepository;
import ApplicationServer.Model.Project;
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
    private SprintRepository sprintRepository;

    public ProjectController(ProjectRepository projectRepository, UsersInProjectsRepository usersInProjectsRepository, SprintRepository sprintRepository) {
        this.projectRepository = projectRepository;
        this.usersInProjectsRepository = usersInProjectsRepository;
        this.sprintRepository = sprintRepository;
    }

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
        return ResponseEntity.status(HttpStatus.OK).body(projectRepository.findAll());
    }

    @RequestMapping(value = "/sprint", method = RequestMethod.GET)
    public List<?> getSprint(
            @RequestParam(value = "id", required = false) Integer id) {

        if (id != null) {
            return sprintRepository.findBySprintId(id);
        }
        return sprintRepository.findAll();
    }

    private List<?> projectsForUser(String username) {
        List<UsersInProjects> projectIds = usersInProjectsRepository.findByUserProjectKeyUsername(username);
        List<Project> projectList = new ArrayList<>();
        for (UsersInProjects usersInProjects : projectIds) {
            projectList.add(projectRepository.findByProjectId(usersInProjects.getUserProjectKey().getProjectId()).get(0));
        }
        return projectList;
    }

//    private List<Project> allProjectsForUser(Integer userId) {
////        return projectRepository
//    }

    /**
     * Method for creating a new project. Processing data in JSON form sent from client site of the system.
     * Creates a project and saves it to the database.
     * If the project was created successfully it returns  a HTTP Response Status with code '200 OK'
     * If the project failed to be created  it returns  a HTTP Response Status with code '400 Bad Request'
     *
     * @param project Project object in format of Json received from client
     * @return <i>HTTP 200 - OK</i> code if project created. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody Project project) {
        if (projectRepository.save(project) != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Project created");
        }
        // If anything above goes wrong
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Creation of the Project failed");
    }

}