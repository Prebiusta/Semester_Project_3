package ApplicationServer.Controllers;

import ApplicationServer.JPA.ProjectRepository;
import ApplicationServer.JPA.UserStoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserStoryController {
    private UserStoryRepository userStoryRepository;

    public UserStoryController(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

    /**
     * Returns User Story/Use Stories from the database. If specified only Id, returns one User Story.
     * If specified backlogId, returns List of User Stories for Project Backlog with given ID.
     *
     * EXAMPLE:
     *  http://{host}:6969/api/userStory?id=52
     *  http://{host}:6969/api/userStory?backlogId=7
     *
     * @param backlogId Id of Project Backlog
     * @param id Id of desired User Story
     * @return List of User Stories or specific User Story
     */
    @RequestMapping(value = "/userStory", method = RequestMethod.GET)
    public ResponseEntity<?> getUserStory(
            @RequestParam(value = "backlogId", required = false) Integer backlogId,
            @RequestParam(value = "id", required = false) Integer id) {
        if (backlogId != null){
            return ResponseEntity.status(HttpStatus.OK).body(userStoryRepository.findAllByProjectBacklogId(backlogId));
        } else if (id != null){
            return ResponseEntity.status(HttpStatus.OK).body(userStoryRepository.findByUserStoryId(id));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not specified");
    }
}
