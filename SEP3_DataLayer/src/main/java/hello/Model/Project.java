package hello.Model;
import javax.persistence.*;


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

    public Project(){

    }

    public Project(String name, String status, int numberOfIterations, int lengthOfSprint) {
        this.name = name;
        this.status = status;
        this.numberOfIterations = numberOfIterations;
        this.lengthOfSprint = lengthOfSprint;
    }

    public int getLengthOfSprint() {
        return lengthOfSprint;
    }

    public int getNumberOfIterations() {
        return numberOfIterations;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", numberOfIterations=" + numberOfIterations +
                ", lengthOfSprint=" + lengthOfSprint +
                '}';
    }
}
