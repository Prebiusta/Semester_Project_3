package ApplicationServer.Controllers;

import ApplicationServer.JPA.UserRepository;
import ApplicationServer.JPA.UsersInProjectsRepository;
import ApplicationServer.Model.AdministratorsInProjects;
import ApplicationServer.Model.CompositeKeys.AdministratorProjectKey;
import ApplicationServer.Model.User;
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
    private UserRepository userRepository;

    public UsersInProjectsController(UsersInProjectsRepository usersInProjectsRepository, UserRepository userRepository) {
        this.usersInProjectsRepository = usersInProjectsRepository;
        this.userRepository = userRepository;
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
    public ResponseEntity<?> getUsersInProjects(
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

    /**
     * Getting List of usernames which are not included in project.
     *
     * EXAMPLE:
     *  http://{host}:6969/api/usersNotInProjects?projectId=4
     *
     * @param projectId id of the project
     * @return <i>HTTP 200 - OK</i> code with all users not in project if list is not empty. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/usersNotInProjects", method = RequestMethod.GET)
    public ResponseEntity<?> getUsersNotInProjects(
            @RequestParam(value = "projectId") Integer projectId) {
        var usersInProjectsEntries = usersInProjectsRepository.findByUserProjectKeyProjectId(projectId);
        var allUsersEntries = userRepository.findAll();

        ArrayList<String> usersNotInProjects = new ArrayList<>();

        for (User user : allUsersEntries){
            usersNotInProjects.add(user.getUsername());
        }

        for (UsersInProjects entry : usersInProjectsEntries){
            usersNotInProjects.remove(entry.getUserProjectKey().getUsername());
        }

        if(!usersNotInProjects.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(usersNotInProjects);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not users found");
    }
}
