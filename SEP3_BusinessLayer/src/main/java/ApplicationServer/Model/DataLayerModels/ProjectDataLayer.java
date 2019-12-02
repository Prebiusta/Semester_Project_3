package ApplicationServer.Model.DataLayerModels;

public class ProjectDataLayer {
    private int projectId;
    private String name;
    private String status;
    private int numberOfIterations;
    private int lengthOfSprint;
    private String administratorUsername;

    public ProjectDataLayer(){

    }

    public ProjectDataLayer(int projectId, String name, String status, int numberOfIterations, int lengthOfSprint, String administratorUsername) {
        this.projectId = projectId;
        this.name = name;
        this.status = status;
        this.numberOfIterations = numberOfIterations;
        this.lengthOfSprint = lengthOfSprint;
        this.administratorUsername = administratorUsername;
    }

    public ProjectDataLayer(String name, String status, int numberOfIterations, int lengthOfSprint, String administratorUsername) {
        this.name = name;
        this.status = status;
        this.numberOfIterations = numberOfIterations;
        this.lengthOfSprint = lengthOfSprint;
        this.administratorUsername = administratorUsername;
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

    public String getAdministratorUsername() {
        return administratorUsername;
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
