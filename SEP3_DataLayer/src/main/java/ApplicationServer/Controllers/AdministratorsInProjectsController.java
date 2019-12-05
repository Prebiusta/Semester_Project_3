package ApplicationServer.Controllers;

import ApplicationServer.JPA.AdministratorsInProjectsRepository;
import ApplicationServer.Model.AdministratorsInProjects;
import ApplicationServer.Model.CompositeKeys.AdministratorProjectKey;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class AdministratorsInProjectsController {
    private AdministratorsInProjectsRepository administratorsInProjectsRepository;

    public AdministratorsInProjectsController(AdministratorsInProjectsRepository administratorsInProjectsRepository) {
        this.administratorsInProjectsRepository = administratorsInProjectsRepository;
    }

    /**
     * Post method assigning administrator privileges to the project by passing username and project id.
     * EXAMPLE
     * http://{host}:6969/api/assignAdmin?projectId=1&username=David
     *
     * @param projectId Id of the project
     * @param username  username of user who should become administrator of given project
     * @return <i>HTTP 201 - CREATED</i> code if administrator is added. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/assignAdmin", method = RequestMethod.POST)
    public ResponseEntity<?> assignAdmin(
            @RequestParam(value = "projectId") Integer projectId,
            @RequestParam(value = "username") String username) {

        AdministratorsInProjects adminEntry = new AdministratorsInProjects(new AdministratorProjectKey(username, projectId));

        try {
            var databaseResponse = administratorsInProjectsRepository.save(adminEntry);
            return ResponseEntity.status(HttpStatus.CREATED).body(databaseResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Removes admin privileges from user. Deletes entry in database.
     *
     * EXAMPLE:
     *  http://{host}:6969/api/removeAdmin?projectId=1&username=David
     *
     *
     * @param projectId ID of the project.
     * @param username Username of the user who's privileges should be removed.
     * @return <i>HTTP 200 - OK</i> code if administrator is removed. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/removeAdmin", method = RequestMethod.POST)
    public ResponseEntity<?> removeAdmin(
            @RequestParam(value = "projectId") Integer projectId,
            @RequestParam(value = "username") String username) {
        try{
            var entryToDelete = new AdministratorsInProjects(new AdministratorProjectKey(username, projectId));
            administratorsInProjectsRepository.delete(entryToDelete);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted " + username + " from project " + projectId + ".");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
