package ApplicationServer.Controllers;

import ApplicationServer.JPA.UsersInProjectsRepository;
import ApplicationServer.Model.UsersInProjects;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersInProjectsController {
    private UsersInProjectsRepository usersInProjectsRepository;

    public UsersInProjectsController(UsersInProjectsRepository usersInProjectsRepository) { this.usersInProjectsRepository = usersInProjectsRepository;}

    /**
     * HTTP Method to get all users that are in a project.
     *
     * Endpoint
     * http://<b>{host}</b>:8080/api/users_in_projects?projectId={id}
     *
     * Example
     * http://localhost:8080/api/users_in_projects?projectId={id}   =
     *
     * @param projectId of the project, which is unique for all the projects
     * @return returns a list of sprints depending on the project ID
     */
    @RequestMapping(value = "/users_in_projects", method = RequestMethod.GET)
    public List<UsersInProjects> getUsersInProjects(@RequestParam(value = "projectId", required = false) Integer projectId) {
            if (projectId != null) {
                return usersInProjectsRepository.findByProjectId(projectId);
            }
            return usersInProjectsRepository.findAll();
    }
}


