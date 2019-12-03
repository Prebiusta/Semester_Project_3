package ApplicationServer.Controllers;

import ApplicationServer.JPA.UsersInProjectsRepository;
import ApplicationServer.Model.UsersInProjects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class UsersInProjectsController {
    private UsersInProjectsRepository usersInProjectsRepository;

    public UsersInProjectsController(UsersInProjectsRepository usersInProjectsRepository) {
        this.usersInProjectsRepository = usersInProjectsRepository;
    }


    /**
     * Getting List of usernames for desired project
     *
     * EXAMPLE:
     *  http://{host}:6969/api/usersInProjects?projectId=4
     *
     * @param projectId id of the project
     * @return returns List of usernames for project with given ID
     */
    @RequestMapping(value = "/usersInProjects", method = RequestMethod.GET)
    public ResponseEntity<?> getProject(
            @RequestParam(value = "projectId") Integer projectId) {
        var usersInProjectsEntries = usersInProjectsRepository.findByUserProjectKeyProjectId(projectId);

        ArrayList<String> usersInProject = new ArrayList<>();
        for (UsersInProjects entry : usersInProjectsEntries){
            usersInProject.add(entry.getUserProjectKey().getUsername());
        }

        if(!usersInProject.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(usersInProject);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not users found");

    }

}
