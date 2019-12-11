package ApplicationServer.Controllers;

import ApplicationServer.JPA.TaskRepository;
import ApplicationServer.Model.Tasks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {
    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //region Create Task POST
    /**
     * Creates a task for chosen Sprint User Story
     * @param task Task object in JSON format
     * @return <i>HTTP 201 - CREATED</i> code with created row if Task is created. Returns <i>HTTP 400 - BAD_REQUEST</i> if error occurred.
     */
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public ResponseEntity<?> createTask(
            @RequestBody Tasks task
    ){
        try {
            Tasks savedTask = taskRepository.save(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error " + e.getMessage());
        }
    }
    //endregion
}
