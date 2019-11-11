package ApplicationServer.Controllers;

import ApplicationServer.JPA.ProjectRepository;
import ApplicationServer.Model.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ProjectController {
    private ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;


    }

    /**
     *
     * HTTP Method to get the projects by two nullable parameters.
     * It is not required to specify them and also not possible to specify both of them.
     *
     * Example
     * http://<b>{host}</b>:8080/api/project?status=completed   To find by status
     * http://<b>{host}</b>:8080/api/project?id=2               To find by Id
     * http://<b>{host}</b>:8080/api/project                    To find all the existing projects
     *
     *
     * Json template{
     *          *
     *          *  "name":"name",
     *          *  "status":"status",
     *          *  "numberOfIterations":"numberOfIterations",
     *          *  "lengthOfSprint":"length"
     *          * }
     * @param status specifying the status of the project ("completed", "ongoing")
     * @param id of the project, which is unique for all the projects
     * @return returns a list of projects depending on the request that we made
     */
    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public List<Project> getProject(
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "id", required = false) Integer id) {
        if (status != null) {
            return projectRepository.findAllByStatus(status);
        } else if (id != null) {
            return projectRepository.findByProjectId(id);
        }
        return projectRepository.findAll();
    }

    /**
     * Method for creating a new project. Processing data in JSON form sent from client site of the system.
     * Creates a project and saves it to the database.
     * If the project was created successfully it returns  a HTTP Response Status with code '200 OK'
     * If the project failed to be created  it returns  a HTTP Response Status with code '400 Bad Request'
     *
     *

     *
     * @param project Project object in format of Json recieved from client
     * @return <i>HTTP 200 - OK</i> code if project created. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody Project project) {


        if (projectRepository.save(project) != null){
            return ResponseEntity.status(HttpStatus.OK).body("Project created");
        }

        // If anything above goes wrong
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Creation of the Project failed");
    }

}