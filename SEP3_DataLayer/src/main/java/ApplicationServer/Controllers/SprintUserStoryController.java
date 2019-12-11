package ApplicationServer.Controllers;

import ApplicationServer.JPA.SprintBacklogRepository;
import ApplicationServer.JPA.SprintUserStoryRepository;
import ApplicationServer.Model.Remote.AssignUserStory;
import ApplicationServer.Model.SprintBacklog;
import ApplicationServer.Model.SprintUserStory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class SprintUserStoryController {
    private SprintUserStoryRepository sprintUserStoryRepository;
    private SprintBacklogRepository sprintBacklogRepository;

    public SprintUserStoryController(SprintUserStoryRepository sprintUserStoryRepository, SprintBacklogRepository sprintBacklogRepository) {
        this.sprintUserStoryRepository = sprintUserStoryRepository;
        this.sprintBacklogRepository = sprintBacklogRepository;
    }

    //region Get Sprint User Story GET
    /**
     * Returns List of Sprint User Story entries from backlog with provided id.
     *
     * @param sprintBacklogId id of Sprint Backlog from where are the Sprint User Stories returned.
     * @return <i>HTTP 200 - OK</i> code with List of Sprint User Stories. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/sprintUserStory", method = RequestMethod.GET)
    public ResponseEntity<?> getSprintUserStoriesForSprintBacklog(
            @RequestParam(value = "sprintBacklogId") Integer sprintBacklogId){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sprintUserStoryRepository.findAllBySprintBacklogId(sprintBacklogId));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error " + e.getMessage());
        }
    }
    //endregion

    //region Assign Sprint User Story POST
    /**
     * Creates new Sprint User Story for selected Sprint Backlog
     *
     * EXAMPLE:
     *  http://{host}:6969/api/sprintUserStory
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
        try {
            SprintBacklog sprintBacklog = sprintBacklogRepository.findBySprintId(assignUserStory.getSprintId());
            SprintUserStory savedSprintUserStory = sprintUserStoryRepository.save(new SprintUserStory(assignUserStory.getUserStoryId(), sprintBacklog.getSprintBacklogId()));
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSprintUserStory);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error " + e.getMessage());
        }
    }
    //endregion
}
