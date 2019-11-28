package ApplicationServer.Model;

import javax.persistence.*;

@Entity
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sprint_id")
    private int sprintId;
    @Column(name="project_id")
    private int projectId;
    @Column(name="sprint_number")
    private int sprintNumber;
    @Column(name="date_started")
    private String dateStarted;
    @Column(name="date_finished")
    private String dateFinished;
    @Column(name="product_owner_id")
    private int productOwnerId;
    @Column(name="scrum_master_id")
    private int scrumMasterId;
    @Column(name="status")
    private String status;

    public Sprint() {}


    public Sprint(int sprintNumber, String dateStarted, String dateFinished, int productOwnerId, int scrumMasterId, String status) {
        this.sprintNumber = sprintNumber;
        this.dateStarted = dateStarted;
        this.dateFinished = dateFinished;
        this.productOwnerId = productOwnerId;
        this.scrumMasterId = scrumMasterId;
        this.status = status;
    }

    public int getSprintId() {
        return sprintId;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getSprintNumber() {
        return sprintNumber;
    }

    public String getDateStarted() {
        return dateStarted;
    }

    public String getDateFinished() {
        return dateFinished;
    }

    public int getProductOwnerId() {
        return productOwnerId;
    }

    public int getScrumMasterId() {
        return scrumMasterId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return
        "Sprint{" +
                "sprintId=" + sprintId +
                ", projectId=" + projectId +
                ", sprintNumber=" + sprintNumber +
                ", dateStarted='" + dateStarted + '\'' +
                ", dateFinished='" + dateFinished + '\'' +
                ", productOwnerId=" + productOwnerId +
                ", scrumMasterId=" + scrumMasterId +
                ", status='" + status + '\'' +
                '}';
    }
}
