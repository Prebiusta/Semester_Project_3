package ApplicationServer.Controllers;

import ApplicationServer.JPA.SprintRepository;
import ApplicationServer.Model.Sprint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SprintController {
    private SprintRepository sprintRepository;

    public SprintController(SprintRepository sprintRepository) {this.sprintRepository = sprintRepository;}

    /**
     * HTTP Method to get the sprints by project ID.
     * It is required to specify project ID otherwise server returns BAD REQUEST 400.
     *
     * Endpoint
     * http://<b>{host}</b>:8080/api/sprint?projectId={id}
     *
     * Example
     * http://localhost:8080/api/sprint?projectId=1
     *
     * Json template{
     *
     *            *   "sprintId":1,
     *            *   "projectId":1,
     *            *   "sprintNumber":1,
     *            *   "dateStarted":"2019-11-21",
     *            *   "dateFinished":"2019-11-21",
     *            *   "productOwnerId":2,
     *            *   "scrumMasterId":2,
     *            *   "status":"completed"
     *
     *          * }
     * @param projectId of the project, which is unique for all the projects
     * @return returns a list of sprints depending on the project ID
     */
    @RequestMapping(value = "/sprint", method = RequestMethod.GET)
    public ResponseEntity<List<Sprint>> getSprints(
            @RequestParam(value = "projectId", required = false) Integer projectId,
            @RequestParam(value = "sprintId", required = false) Integer sprintId) {
        if (projectId != null) {
            return new ResponseEntity<>(sprintRepository.findByProjectId(projectId), HttpStatus.OK);
        } else if (sprintId != null) {
            return new ResponseEntity<>(sprintRepository.findBySprintId(sprintId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
