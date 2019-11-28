package ApplicationServer.Controllers;

import ApplicationServer.JPA.SprintRepository;
import ApplicationServer.Model.Sprint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SprintController {
    private SprintRepository sprintRepository;

    public SprintController(SprintRepository sprintRepository) {this.sprintRepository = sprintRepository;}

    @RequestMapping(value = "/sprint", method = RequestMethod.GET)
    public ResponseEntity<List<Sprint>> getSprints(
            @RequestParam(value = "projectId", required = true) Integer projectId) {
        if (projectId != null) {
            return new ResponseEntity<>(sprintRepository.findByProjectId(projectId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
