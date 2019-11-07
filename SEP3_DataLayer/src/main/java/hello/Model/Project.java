package hello.Model;
import javax.persistence.*;


@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="project_id")
    private int projectkId;
    @Column(name="number_of_iterations")
    private int numberOfIterations;
    @Column(name="status")
    private String status;

    public Project(){

    }



    public Project(int numberOfIterations, String status) {
        this.numberOfIterations=numberOfIterations;
        this.status = status;
    }

    public int getProjectkId() {
        return projectkId;
    }
    public int getNumberOfIterations() {
        return numberOfIterations;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "projectkId=" + projectkId +
                ",numberOfIterations=" + numberOfIterations +
                 '\'' +  ", status='" + status + '\'' +
                '}';
    }
}
