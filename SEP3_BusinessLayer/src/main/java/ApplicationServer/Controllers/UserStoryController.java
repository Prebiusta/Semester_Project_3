package ApplicationServer.Controllers;

import ApplicationServer.Model.ClientModels.UserStoryClient;
import ApplicationServer.Model.DataLayerModels.UserStoryDataLayer;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserStoryController extends ControllerConfiguration {
    /**
     * HTTP Method to get the user story by project backlog ID.
     * It is required to specify project ID otherwise server returns BAD REQUEST 400.
     *
     * Endpoint
     * http://<b>{host}</b>:8081/api/userStory?projectBacklogId={id}
     *
     * Example
     * http://localhost:8081/api/userStory?projectBacklogId=1
     *
     * @param projectBacklogId of the project, which is unique for all the projects
     * @return returns a list of user stories depending on the project backlog ID
     */
    @RequestMapping(value = "/userStory", method = RequestMethod.GET)
    public ResponseEntity<?> getUserStory(
            @RequestParam(value = "projectBacklogId", required = false) Integer projectBacklogId) {
        String jsonUserStories ;
        if (projectBacklogId != null) {
            jsonUserStories = restUtility.getForObject(DataLayerURI + "/api/userStory?projectBacklogId=" + projectBacklogId, String.class);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            List<UserStoryDataLayer> userStoriesFromDataLayer = jsonMapper.readValue(jsonUserStories, new TypeReference<List<UserStoryDataLayer>>(){});
            List<UserStoryClient> userStoriesForClients = new ArrayList<>();
            for(UserStoryDataLayer userStory : userStoriesFromDataLayer) {
                userStoriesForClients.add(new UserStoryClient(userStory.getUserStoryId(), userStory.getProjectBacklogId(), userStory.getPriority(), userStory.getDescription(), userStory.getDifficulty(), userStory.getStatus()));
            }
            String jsonForClient = jsonMapper.writeValueAsString(userStoriesForClients);
            return new ResponseEntity<>(jsonForClient, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
