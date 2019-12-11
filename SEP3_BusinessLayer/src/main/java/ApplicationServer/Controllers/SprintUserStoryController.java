package ApplicationServer.Controllers;

import ApplicationServer.Model.DataLayerModels.AssignUserStory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

@RestController
@RequestMapping(value = "/api")
public class SprintUserStoryController extends ControllerConfiguration {
    /**
     * Sends JSON format of AssignUserStory class to data tier to register it in database
     *
     * EXAMPLE:
     *  http://{host}:8081/api/sprintUserStory
     *
     *  Body:
     *  {
     *      "userStoryId": 5,
     *      "sprintId": 15
     *  }
     *
     * @param assignUserStory AssignUserStory class in JSON format passed as a body
     * @return <i>HTTP 201 - CREATED</i> code with created Sprint User Story. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/sprintUserStory", method = RequestMethod.POST)
    public ResponseEntity<?> assignUserStory(
            @RequestBody AssignUserStory assignUserStory
    ){
        HttpEntity<AssignUserStory> assignUserStoryHttpEntity = new HttpEntity<>(assignUserStory);
        try {
            restUtility.postForLocation(DataLayerURI + "/api/sprintUserStory", assignUserStoryHttpEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            System.out.println("Scrum master couldn't be added");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RestClientException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
