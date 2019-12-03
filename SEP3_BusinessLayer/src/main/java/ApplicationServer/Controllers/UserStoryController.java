package ApplicationServer.Controllers;

import ApplicationServer.Model.ClientModels.UserStoryClient;
import ApplicationServer.Model.DataLayerModels.UserStoryDataLayer;
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
public class UserStoryController extends ControllerConfiguration {
    /**
     * HTTP Method to get the user story by backlog ID.
     *
     * Endpoint
     * http://<b>{host}</b>:8081/api/userStory?backlogId={id}
     *
     * Example
     * http://localhost:8081/api/userStory?backlogId=1
     *
     * @param backlogId of the project, which is unique for all the projects
     * @return returns a list of user stories depending on the backlog ID
     */
    @RequestMapping(value = "/userStory", method = RequestMethod.GET)
    public ResponseEntity<?> getUserStory(
            @RequestParam(value = "backlogId", required = false) Integer backlogId,
            @RequestParam(value = "sprintId", required = false) Integer sprintId) {
        String jsonUserStories;
        if (sprintId != null) {
            jsonUserStories = restUtility.getForObject(DataLayerURI + "/api/userStory?id=" + sprintId, String.class);
        } else if(backlogId != null) {
            jsonUserStories = restUtility.getForObject(DataLayerURI + "/api/userStory?backlogId=" + backlogId, String.class);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            List<UserStoryDataLayer> userStoryFromDataLayer = jsonMapper.readValue(jsonUserStories, new TypeReference<List<UserStoryDataLayer>>(){});
            //For now this block is useless, but later this is where actual remodelling will be taking place
            //--------------------------------------------------------------------||--------------------------------------------------------------------
            List<UserStoryClient> userStoryForClient = new ArrayList<>();
            for(UserStoryDataLayer userStory : userStoryFromDataLayer) {
                userStoryForClient.add(new UserStoryClient(userStory.getUserStoryId(), userStory.getProjectBacklogId(), userStory.getPriority(), userStory.getDescription(), userStory.getDifficulty(), userStory.getStatus()));
            }
            String jsonForClient = jsonMapper.writeValueAsString(userStoryForClient);
            return new ResponseEntity<>(jsonForClient, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
