package ApplicationServer.Model;
import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private List<Sprint> sprints = new ArrayList<>();

    public Project() {
    }

    public Project(String name, String status, int numberOfIterations, int lengthOfSprint) {
        this.name = name;
        this.status = status;
        this.numberOfIterations = numberOfIterations;
        this.lengthOfSprint = lengthOfSprint;
    }

    public Project(String name, String status, int numberOfIterations, int lengthOfSprint, List<Sprint> sprints) {
        this.name = name;
        this.status = status;
        this.numberOfIterations = numberOfIterations;
        this.lengthOfSprint = lengthOfSprint;
        this.sprints = sprints;
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

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(List<Sprint> sprints) {
        this.sprints = sprints;
    }
}

