package ApplicationServer.Controllers;

import ApplicationServer.JPA.ProductBacklogRepository;
import ApplicationServer.JPA.SprintBacklogRepository;
import ApplicationServer.JPA.UserStoryRepository;
import ApplicationServer.Model.UserStory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserStoryController {
    private UserStoryRepository userStoryRepository;
    private ProductBacklogRepository productBacklogRepository;

    public UserStoryController(UserStoryRepository userStoryRepository, ProductBacklogRepository productBacklogRepository) {
        this.userStoryRepository = userStoryRepository;
        this.productBacklogRepository = productBacklogRepository;
    }

    //region Get User Story     ARGS: ID/ProjectBacklogId   METHOD: GET
    /**
     * Returns User Story/Use Stories from the database. If specified only Id, returns one User Story.
     * If specified backlogId, returns List of User Stories for Project Backlog with given ID.
     *
     * EXAMPLE:
     *  http://{host}:6969/api/userStory?id=52
     *  http://{host}:6969/api/userStory?backlogId=7
     *
     * @param projectId Id of the Project
     * @param userStoryId Id of desired User Story
     * @return List of User Stories or specific User Story
     */
    @RequestMapping(value = "/userStory", method = RequestMethod.GET)
    public ResponseEntity<?> getUserStory(
            @RequestParam(value = "projectId", required = false) Integer projectId,
            @RequestParam(value = "userStoryId", required = false) Integer userStoryId) {
        try {
            if (projectId != null) {
                var productBacklogEntry = productBacklogRepository.findByProjectId(projectId);
                System.out.println("Product backlog id" + productBacklogEntry.getProductBacklogId());
                return ResponseEntity.status(HttpStatus.OK).body(userStoryRepository.findAllByProductBacklogId(productBacklogEntry.getProductBacklogId()));
            } else if (userStoryId != null) {
                return ResponseEntity.status(HttpStatus.OK).body(userStoryRepository.findByUserStoryId(userStoryId));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not specified");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");

        }
    }
    //endregion

    //region Create User Story     ARGS: UserStory RequestBody METHOD: POST

    /**
     * Creates User Story in Project Backlog. Requires RequestBody with JSON UserStory object.
     *
     * EXAMPLE:
     *  http://{host}:6969/api/userStory
     *
     *  Body
     *  {
     *      "productBacklogId" : 4,
     *      "priority" : "low",
     *      "description" : "Lorem Ipsum is simply dummy text",
     *      "difficulty" : 56,
     *      "status" : "completed"
     *  }
     *
     * @param userStory JSON of UserStory object
     * @return <i>HTTP 201 - CREATED</i> code with created row if User Story is created. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/userStory", method = RequestMethod.POST)
    public ResponseEntity<?> createUserStory(
            @RequestBody UserStory userStory){
        try {
            UserStory savedUserStory = userStoryRepository.save(userStory);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUserStory);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error " + e.getMessage());
        }
    }
    //endregion
}