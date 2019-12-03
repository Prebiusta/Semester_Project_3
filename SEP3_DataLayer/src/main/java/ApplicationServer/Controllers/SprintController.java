package ApplicationServer.Controllers;

import ApplicationServer.JPA.SprintRepository;
import ApplicationServer.Model.Sprint;
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
     *
     * EXAMPLE
     *  http://{host}:6969/api/sprint?projectId=3
     *  http://{host}:6969/api/sprint?id=18
     *
     * @param id of sprint
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
     * Post method for creating sprint. Used while Sprint Planning. Have to contain all variables. Overrides the original sprint in database
     * which had some variables nulls.
     *
     * EXAMPLE:
     *  http://{host}:6969/api/sprint
     *  Body:
     *  {
     * 	    "projectId" : 8,
     * 	    "sprintNumber" : 1,
     * 	    "dateStarted" : "1999-12-31",
     * 	    "dateFinished" : "1999-12-31",
     * 	    "productOwnerId" : 2,
     * 	    "scrumMasterId" : 1,
     * 	    "status": "ongoing"
     *  }
     *
     * @param sprint Sprint object passed from Business Tier.
     * @return Returns relevant HttpStatus. CREATED if creation was successful or BAD_REQUEST if creation failed.
     */
    @RequestMapping(value = "/sprint", method = RequestMethod.POST)
    public ResponseEntity<?> createSprint(@RequestBody Sprint sprint){
        System.out.println(sprint.toString());
        try {
            var savedSprint = sprintRepository.save(sprint);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSprint);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error saving sprint " + e.getMessage());
        }
    }
}
