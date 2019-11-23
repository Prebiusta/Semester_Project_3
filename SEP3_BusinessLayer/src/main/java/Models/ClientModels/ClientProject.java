package Models.ClientModels;

public class ClientProject {
    private int projectId;
    private String name;
    private String status;
    private int numberOfIterations;
    private int lengthOfSprint;

    public ClientProject(){

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
}
