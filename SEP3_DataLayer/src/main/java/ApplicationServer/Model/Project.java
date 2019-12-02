package ApplicationServer.Model;
import javax.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_id")
    private int projectId;

    @Column(name = "name")
    private String name;

    @Column(name="status")
    private String status;

    @Column(name="number_of_iterations")
    private int numberOfIterations;

    @Column(name = "length_of_sprint")
    private int lengthOfSprint;

    @Transient
    private List<String> admins;

    public Project() {
    }

    public Project(Project project, List<String> admins){
        this(project.projectId, project.name, project.status, project.numberOfIterations, project.lengthOfSprint);
        this.admins = admins;
    }

    public Project(String name, String status, int numberOfIterations, int lengthOfSprint) {
        this.name = name;
        this.status = status;
        this.numberOfIterations = numberOfIterations;
        this.lengthOfSprint = lengthOfSprint;
    }

    public Project(int projectId, String name, String status, int numberOfIterations, int lengthOfSprint) {
        this.projectId = projectId;
        this.name = name;
        this.status = status;
        this.numberOfIterations = numberOfIterations;
        this.lengthOfSprint = lengthOfSprint;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberOfIterations() {
        return numberOfIterations;
    }

    public void setNumberOfIterations(int numberOfIterations) {
        this.numberOfIterations = numberOfIterations;
    }

    public int getLengthOfSprint() {
        return lengthOfSprint;
    }

    public void setLengthOfSprint(int lengthOfSprint) {
        this.lengthOfSprint = lengthOfSprint;
    }

    public List<String> getAdmins() {
        return admins;
    }

    public void setAdmins(List<String> admins) {
        this.admins = admins;
    }
}

