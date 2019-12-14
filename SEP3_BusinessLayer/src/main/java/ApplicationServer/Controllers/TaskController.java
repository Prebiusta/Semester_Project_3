package ApplicationServer.Controllers;

import ApplicationServer.Model.ClientModels.Task;
import ApplicationServer.Model.ClientModels.UserStoryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TaskController {

    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public ResponseEntity<?> getSprintUserStory(
            @RequestParam(value = "sprintUserStoryId") Integer userStoryId
    ){
        //Dummy data for client testing
        Task task1 = new Task(1, 1, "task1", "UNDONE");
        Task task2 = new Task(2, 1, "task2", "UNDONE");
        Task task3 = new Task(3, 1, "task3", "UNDONE");
//        String jsonSpringUserStories = restUtility.getForObject(DataLayerURI + "/api/sprintUserStory?sprintId=" + sprintId, String.class);
//
//        try {
//            List<UserStoryDataLayer> sprintUserStories = jsonMapper.readValue(jsonSpringUserStories, new TypeReference<List<UserStoryDataLayer>>(){});
//
//            return ResponseEntity.status(HttpStatus.OK).body(sprintUserStories);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        //Dummy data for testing
        UserStoryClient userStoryClient1 = new UserStoryClient(1, 2, "LOW", "UserStory1", 3, "ONGOING");
        UserStoryClient userStoryClient2 = new UserStoryClient(2, 2, "MEDIUM", "UserStory2", 5, "ONGOING");
        UserStoryClient userStoryClient3 = new UserStoryClient(3, 2, "HIGH", "UserStory3", 6, "ONGOING");
        List<UserStoryClient> userStoryClientList = new ArrayList<>();
        userStoryClientList.add(userStoryClient1);
        userStoryClientList.add(userStoryClient2);
        userStoryClientList.add(userStoryClient3);
        return ResponseEntity.status(HttpStatus.OK).body(userStoryClientList);
    }
}
