package ApplicationServer.Controllers;

import ApplicationServer.Model.ClientModels.SprintClient;
import ApplicationServer.Model.DataLayerModels.SprintDataLayer;
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
public class SprintsController extends ControllerConfiguration {

    /**
     * HTTP Method to get the sprints by project ID.
     * It is required to specify project ID otherwise server returns BAD REQUEST 400.
     *
     * Endpoint
     * http://<b>{host}</b>:8081/api/sprint?projectId={id}
     *
     * Example
     * http://localhost:8081/api/sprint?projectId=1
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
    public ResponseEntity<?> getSprints(
            @RequestParam(value = "projectId", required = true) Integer projectId) {
        if (projectId != null) {
            String jsonSprints = restUtility.getForObject(DataLayerURI + "/api/sprint?projectId=" + projectId, String.class);
            try {
                List<SprintDataLayer> sprintsFromDataLayer = jsonMapper.readValue(jsonSprints, new TypeReference<List<SprintDataLayer>>(){});
                //For now this block is useless, but later this is where actual remodelling will be taking place
                //--------------------------------------------------------------------||--------------------------------------------------------------------
                List<SprintClient> sprintsForClients = new ArrayList<>();
                for(SprintDataLayer sprint : sprintsFromDataLayer) {
                    sprintsForClients.add(new SprintClient(sprint.getSprintId(), sprint.getProjectId(), sprint.getSprintNumber(), sprint.getDateStarted(), sprint.getDateFinished(), sprint.getProductOwnerId(), sprint.getScrumMasterId(), sprint.getStatus()));
                }
                String jsonForClient = jsonMapper.writeValueAsString(sprintsForClients);
                return new ResponseEntity<>(jsonForClient, HttpStatus.OK);
            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
