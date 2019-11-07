package hello.Controllers;

import hello.JPA.TaskRepository;
import hello.Model.Tasks;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    /**
     * Http method with two nullable parameters. Its not possible to specify both parameters.
     * Examples:
     * http://<b>{host}</b>:8080/api/task?id=8 where host is IP address of computer
     * http://<b>{host}</b>:8080/api/task?status=approved
     *
     * @param status specifying status of the task -> undone, waiting, approved
     * @param id id of the task
     * @return returns array of Tasks
     */
    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public List<Tasks> getTasks(
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "id", required = false) Integer id) {
        if (status != null) {
            return taskRepository.findAllByStatus(status);
        } else if (id != null) {
            return taskRepository.findByTaskId(id);
        }
        return taskRepository.findAll();
    }
}