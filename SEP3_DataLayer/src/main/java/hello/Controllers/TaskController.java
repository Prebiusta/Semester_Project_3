package hello.Controllers;

import hello.JPA.TaskRepository;
import hello.Model.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/task")
    public List<Tasks> getTasks(@RequestParam(value = "status", required = false) String status) {
        if (status == null)
            return taskRepository.findAll();
        else
            return taskRepository.findAllByStatus(status);
    }

//    public List<Task> tasks(@RequestParam(value="project_id", required = false) Integer project_id, @RequestParam(value="sprint_number", required = false) Integer sprint_number){
//
//    }
}