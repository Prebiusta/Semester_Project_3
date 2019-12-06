package ApplicationServer.Controllers;

import ApplicationServer.JPA.SprintRepository;
import ApplicationServer.Model.Sprint;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SprintController {
    private SprintRepository sprintRepository;

    /**
     * Public constructor user by dependency injection
     *
     * @param sprintRepository JPA Repository
     */
    public SprintController(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }


    /**
     * Used to get information about sprints for specified project or information about sprint specified by id.
     * <p>
     * EXAMPLE
     * http://{host}:6969/api/sprint?projectId=3
     * http://{host}:6969/api/sprint?id=18
     *
     * @param id        of sprint
     * @param projectId of project
     * @return One sprint if 'id' specified or List of sprints for project with given 'projectId'.
     */
    @RequestMapping(value = "/sprint", method = RequestMethod.GET)
    public ResponseEntity<?> getSprint(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "projectId", required = false) Integer projectId) {
        if (id != null) {
            return ResponseEntity.status(HttpStatus.OK).body(sprintRepository.findBySprintId(id));
        } else if (projectId != null) {
            return ResponseEntity.status(HttpStatus.OK).body(sprintRepository.findAllByProjectId(projectId));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not allowed to get all database Sprints");
    }

    /**
     * <p></>Post method for creating sprint. Used while Sprint Planning. Have to contain all variables. Overrides the original sprint in database
     * which had some variables nulls.</p>
     *
     * EXAMPLE:
     *  http://{host}:6969/api/sprint
     * Body:
     *  {
     *      "projectId" : 8,
     *      "sprintNumber" : 1,
     *      "dateStarted" : "1999-12-31",
     *      "dateFinished" : "1999-12-31",
     *      "productOwnerUsername" : 2,
     *      "scrumMasterUsername" : 1,
     *      "status": "ongoing"
     *  }
     *
     * @param sprint Sprint object passed from Business Tier.
     * @return Returns relevant HttpStatus. CREATED if creation was successful or BAD_REQUEST if creation failed.
     */
    @RequestMapping(value = "/sprint", method = RequestMethod.POST)
    public ResponseEntity<?> createSprint(@RequestBody Sprint sprint) {
        System.out.println(sprint.toString());
        try {
            var savedSprint = sprintRepository.save(sprint);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSprint);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error saving sprint " + e.getMessage());
        }
    }

    /**
     * Assigns a product owner to the sprint. Taking parameters of sprint id and username.
     *
     * EXAMPLE:
     *  http://{host}:6969/api/productOwner?sprintId=10&username=David
     *
     * @param sprintId id of the sprint
     * @param username username of user to become product owner
     * @return <i>HTTP 200 - OK</i> code with sprint object if product owner is assigned. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/productOwner", method = RequestMethod.POST)
    public ResponseEntity<?> assignProductOwner(
            @RequestParam(value = "sprintId") Integer sprintId,
            @RequestParam(value = "username") String username) {
        try {
            var originalSprint = sprintRepository.findBySprintId(sprintId);
            originalSprint.setproductOwnerUsername(username);
            var updatedSprint = sprintRepository.save(originalSprint);
            return ResponseEntity.status(HttpStatus.OK).body(updatedSprint);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Assigns a scrum master to the sprint. Taking parameters of sprint id and username.
     *
     * EXAMPLE:
     *  http://{host}:6969/api/scrumMaster?sprintId=10&username=David
     *
     * @param sprintId id of the sprint
     * @param username username of user to become scrum master
     * @return <i>HTTP 200 - OK</i> code with sprint object if scrum master is assigned. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/scrumMaster", method = RequestMethod.POST)
    public ResponseEntity<?> assignScrumMaster(
            @RequestParam(value = "sprintId") Integer sprintId,
            @RequestParam(value = "username") String username) {
        try {
            var originalSprint = sprintRepository.findBySprintId(sprintId);
            originalSprint.setscrumMasterUsername(username);
            var updatedSprint = sprintRepository.save(originalSprint);
            return ResponseEntity.status(HttpStatus.OK).body(updatedSprint);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
