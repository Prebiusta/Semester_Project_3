package ApplicationServer.Model.DataLayerModels;

public class SprintDataLayer {

    private int sprintId;
    private int projectId;
    private int sprintNumber;
    private String dateStarted;
    private String dateFinished;
    private int productOwnerId;
    private int scrumMasterId;
    private String status;

    public SprintDataLayer(int sprintId, int projectId, int sprintNumber, String dateStarted, String dateFinished, int productOwnerId, int scrumMasterId, String status) {
        this.projectId = projectId;
        this.sprintId = sprintId;
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
