package ApplicationServer.Controllers;

import ApplicationServer.JPA.ProjectRepository;
import ApplicationServer.Model.Project;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ProjectController {
    private ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public List<Project> getProject(
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "id", required = false) Integer id) {
        if (status != null) {
            return projectRepository.findAllByStatus(status);
        } else if (id != null) {
            return projectRepository.findByProjectId(id);
        }
        return projectRepository.findAll();
    }
}