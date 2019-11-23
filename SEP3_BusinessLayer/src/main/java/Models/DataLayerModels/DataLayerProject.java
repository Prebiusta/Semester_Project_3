package Models.DataLayerModels;


public class DataLayerProject {

    private int projectId;
    private String name;
    private String status;
    private int numberOfIterations;
    private int lengthOfSprint;

    public DataLayerProject(){

    }

    public DataLayerProject(int projectId, String name, String status, int numberOfIterations, int lengthOfSprint) {
        this.projectId = projectId;
        this.name = name;
        this.status = status;
        this.numberOfIterations = numberOfIterations;
        this.lengthOfSprint = lengthOfSprint;
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
