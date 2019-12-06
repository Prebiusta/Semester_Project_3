package ApplicationServer.Controllers;

import ApplicationServer.Model.ClientModels.ProjectClient;
import ApplicationServer.Model.ClientModels.UserProjectClient;
import ApplicationServer.Model.DataLayerModels.ProjectDataLayer;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ProjectController extends ControllerConfiguration{

    /**
     * HTTP Method to get the projects by two nullable parameters.
     * It is not required to specify them and also not possible to specify both of them.
     * Endpoint
     *  http://<b>{host}</b>:8081/api/project
     *
     * Example of request with nullable parameters
     * http://<b>{host}</b>:8081/api/project?status=completed   To find by status
     * http://<b>{host}</b>:8081/api/project?id=2               To find by Id
     * http://<b>{host}</b>:8081/api/project                    To find all the existing projects
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
    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public ResponseEntity<List<ProjectClient>> getProject(
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "username", required = true) String username) {
        String jsonProjects;
        if (status != null) {
            jsonProjects = restUtility.getForObject(DataLayerURI + "/api/project?status=" + status, String.class);
        } else if (id != null) {
            jsonProjects = restUtility.getForObject(DataLayerURI + "/api/project?id=" + id, String.class);
        } else if (username != null){
            jsonProjects = restUtility.getForObject(DataLayerURI + "/api/project?username=" + username, String.class);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            List<ProjectDataLayer> projectsFromDataLayer = jsonMapper.readValue(jsonProjects, new TypeReference<List<ProjectDataLayer>>(){});
            //For now this block is useless, but later this is where actual remodelling will be taking place
            //--------------------------------------------------------------------||--------------------------------------------------------------------
            List<ProjectClient> projectsForClients = new ArrayList<>();
            for(ProjectDataLayer project : projectsFromDataLayer) {
                projectsForClients.add(new ProjectClient(project.getProjectId(), project.getName(), project.getStatus(), project.getNumberOfIterations(), project.getLengthOfSprint(), project.getAdmins()));
            }
            for(ProjectClient projectClient : projectsForClients) {
                for(String admin : projectClient.getAdmins()) {
                    if(admin.equals(username)) {
                        projectClient.setAdministrator();
                    }
                }
            }
            //--------------------------------------------------------------------||--------------------------------------------------------------------
            return new ResponseEntity<>(projectsForClients, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Method for creating a new project. Processing data in JSON form sent from client site of the system.
     * Remodels the project and sends it to Data Layer.
     * If the project was created successfully it returns  a HTTP Response Status with code '200 OK'
     * If the project failed to be created  it returns  a HTTP Response Status with code '400 Bad Request'
     * Endpoint
     *      * http://<b>{host}</b>:8081/api/createProject

     * @param project ProjectDataLayer object in format of Json received from client
     * @return <i>HTTP 200 - OK</i> code if project created. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */

    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public ResponseEntity<ProjectClient> create(
            @RequestBody ProjectClient project,
            @RequestParam(value = "username") String username) {
        //For now this block is useless, but later this is where actual remodelling will be taking place
        //--------------------------------------------------------------------||--------------------------------------------------------------------
        ProjectDataLayer projectForDataLayer = new ProjectDataLayer(project.getName(), project.getStatus(), project.getNumberOfIterations(), project.getLengthOfSprint(), project.getAdmins());
        HttpEntity<ProjectDataLayer> projectDataLayerHttpEntity = new HttpEntity<>(projectForDataLayer);
        //--------------------------------------------------------------------||--------------------------------------------------------------------
        try {
            restUtility.postForLocation(DataLayerURI + "/api/project?username=" + username, projectDataLayerHttpEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            System.out.println("Project couldn't be created");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RestClientException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Add new entry to UsersInProjects table.
     * EXAMPLE:
     *  http://{host}:8081/api/addUser
     *
     * @return <i>HTTP 201 - CREATED</i> code with saved object in body if user is added to the project. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<?> addUserToProject(UserProjectClient userProjectClient) {
        String username = userProjectClient.getUsername();
        int projectId = userProjectClient.getProjectId();
        HttpEntity<String> projectDataLayerHttpEntity = new HttpEntity<>(username);
        //--------------------------------------------------------------------||--------------------------------------------------------------------
        try {
            restUtility.postForLocation(DataLayerURI + "/api/addUser?projectId=" + projectId + "&username=" + username, projectDataLayerHttpEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            System.out.println("User couldn't be added");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RestClientException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Post method assigning administrator privileges to the project.
     * EXAMPLE
     * http://{host}:8081/api/assignAdmin
     *
     * @return <i>HTTP 201 - CREATED</i> code if administrator is added. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/assignAdmin", method = RequestMethod.POST)
    public ResponseEntity<?> assignAdmin(UserProjectClient userProjectClient) {
        String username = userProjectClient.getUsername();
        int projectId = userProjectClient.getProjectId();
        HttpEntity<String> projectDataLayerHttpEntity = new HttpEntity<>(username);
        try {
            restUtility.postForLocation(DataLayerURI + "/api/assignAdmin?projectId=" + projectId + "&username=" + username, projectDataLayerHttpEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            System.out.println("Admin couldn't be assigned");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RestClientException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Removes admin privileges from user. Deletes entry in database.
     *
     * EXAMPLE:
     *  http://{host}:8081/api/removeAdmin
     *
     * @return <i>HTTP 200 - OK</i> code if administrator is removed. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/removeAdmin", method = RequestMethod.POST)
    public ResponseEntity<?> removeAdmin(UserProjectClient userProjectClient) {
        String username = userProjectClient.getUsername();
        int projectId = userProjectClient.getProjectId();
        HttpEntity<String> projectDataLayerHttpEntity = new HttpEntity<>(username);
        try {
            restUtility.postForLocation(DataLayerURI + "/api/removeAdmin?projectId=" + projectId + "&username=" + username, projectDataLayerHttpEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            System.out.println("Admin couldn't be deleted");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RestClientException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}