package ApplicationServer.Model.ClientModels;

public class ProjectClient {

    private int projectId;
    private String name;
    private String status;
    private int numberOfIterations;
    private int lengthOfSprint;
    private String administratorUsername;

    public ProjectClient(){

    }

    public ProjectClient(int projectId, String name, String status, int numberOfIterations, int lengthOfSprint, String administratorUsername) {
        this.projectId = projectId;
        this.name = name;
        this.status = status;
        this.numberOfIterations = numberOfIterations;
        this.lengthOfSprint = lengthOfSprint;
        this.administratorUsername = administratorUsername;
    }

    public ProjectClient(String name, String status, int numberOfIterations, int lengthOfSprint, String administratorUsername) {
        this.name = name;
        this.status = status;
        this.numberOfIterations = numberOfIterations;
        this.lengthOfSprint = lengthOfSprint;
        this.administratorUsername = administratorUsername;
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

    public int getNumberOfIterations() {
        return numberOfIterations;
    }

    public int getLengthOfSprint() {
        return lengthOfSprint;
    }

    public String getAdministratorUsername() {
        return administratorUsername;
    }

    @Override
    public String toString() {
        return "ProjectDataLayer{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", numberOfIterations=" + numberOfIterations +
                ", lengthOfSprint=" + lengthOfSprint +
                '}';
    }
}
