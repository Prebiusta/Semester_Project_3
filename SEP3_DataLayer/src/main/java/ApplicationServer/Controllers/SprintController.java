package ApplicationServer.Controllers;

import ApplicationServer.JPA.SprintRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
