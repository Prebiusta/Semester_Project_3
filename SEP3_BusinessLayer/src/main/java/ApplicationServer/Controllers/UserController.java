package ApplicationServer.Controllers;


import ApplicationServer.Model.ClientModels.UserForDisplay;
import ApplicationServer.Model.ClientModels.UsersInProjectsClient;
import ApplicationServer.Model.DataLayerModels.UserDataLayer;
import ApplicationServer.Model.DataLayerModels.UsersInProjectDataLayer;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController extends ControllerConfiguration {

    /**
     * HTTP Method to get all users or specific ones using username as a parameter.
     *
     * Endpoint
     *  http://<b>{host}</b>:8081/api/user
     *
     * Example of request
     * http://localhost:8081/api/user
     *
     * @param username specifying username
     * @return returns a list of all users or specific user if parameter is used
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<UserForDisplay>> getUsers(
            @RequestParam(value = "username", required = false) String username) {
        String jsonUsers;
        if(username != null) {
            jsonUsers = restUtility.getForObject(DataLayerURI + "/api/user?username=" + username, String.class);
        } else {
            jsonUsers = restUtility.getForObject(DataLayerURI + "/api/user", String.class);
        }
        try {
            List<UserDataLayer> usersFromDataLayer = jsonMapper.readValue(jsonUsers, new TypeReference<List<UserDataLayer>>(){});
            List<UserForDisplay> usersForDisplay = new ArrayList<>();
            for(UserDataLayer userDataLayer : usersFromDataLayer) {
                usersForDisplay.add(new UserForDisplay(userDataLayer.getUsername(), userDataLayer.getFirstName(), userDataLayer.getLastName()));
            }
            return new ResponseEntity<>(usersForDisplay, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * HTTP Method to get all users or specific ones using username as a parameter.
     *
     * Endpoint
     *  http://<b>{host}</b>:8081/api/usersInProjects?projectId={id}
     *
     * Example of request
     * http://localhost:8081/api/usersInProjects?projectId={id}
     *
     * @param projectId specifying username
     * @return returns a list of all users or specific user if parameter is used
     */
    @RequestMapping(value = "/usersInProjects", method = RequestMethod.GET)
    public ResponseEntity<List<UsersInProjectsClient>> getUsersInProjects(
            @RequestParam(value = "projectId", required = false) Integer projectId) {
        String jsonUsersInProjects;
        if(projectId != null) {
            jsonUsersInProjects = restUtility.getForObject(DataLayerURI + "/api/usersInProjects?projectId=" + projectId, String.class);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);        }
        try {
            List<UsersInProjectDataLayer> usersInProjectsFromDataLayer = jsonMapper.readValue(jsonUsersInProjects, new TypeReference<List<UsersInProjectDataLayer>>(){});
            List<UsersInProjectsClient> usersForDisplay = new ArrayList<>();
            for(UsersInProjectDataLayer usersInProjectDataLayer : usersInProjectsFromDataLayer) {
                usersForDisplay.add(new UsersInProjectsClient(usersInProjectDataLayer.getProjectId(), usersInProjectDataLayer.getUsername()));
            }
            return new ResponseEntity<>(usersForDisplay, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
