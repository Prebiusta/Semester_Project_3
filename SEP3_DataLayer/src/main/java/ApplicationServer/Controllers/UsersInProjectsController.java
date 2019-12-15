package ApplicationServer.Controllers;

import ApplicationServer.JPA.AdministratorsInProjectsRepository;
import ApplicationServer.JPA.UserRepository;
import ApplicationServer.JPA.UsersInProjectsRepository;
import ApplicationServer.Model.AdministratorsInProjects;
import ApplicationServer.Model.Remote.UserPublicInfo;
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

    //region Get Users In Project GET
    /**
     * Getting List of usernames for desired project
     *
     * EXAMPLE:
     *  http://{host}:6969/api/usersInProjects?projectId=4
     *
     * @param projectId id of the project
     * @return <i>HTTP 200 - OK</i> code with list of Users. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/usersInProjects", method = RequestMethod.GET)
    public ResponseEntity<?> getUsersInProjects(
            @RequestParam(value = "projectId") Integer projectId) {
        var usersInProjectsEntries = usersInProjectsRepository.findByUserProjectKeyProjectId(projectId);

        ArrayList<UserPublicInfo> usersInProject = new ArrayList<>();

        for (UsersInProjects entry : usersInProjectsEntries){
            User user = userRepository.findByUsername(entry.getUserProjectKey().getUsername());
            usersInProject.add(new UserPublicInfo(user.getUsername(), user.getFirstName(), user.getLastName()));
        }

        if(!usersInProject.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(usersInProject);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not users found");
    }
    //endregion
}
