package ApplicationServer.Model.ClientModels;

import java.io.Serializable;

public class ProjectClient {

    private int projectId;
    private String name;
    private String status;
    private int numberOfIterations;
    private int lengthOfSprint;

    public ProjectClient(){

    }

    public ProjectClient(int projectId, String name, String status, int numberOfIterations, int lengthOfSprint) {
        this.projectId = projectId;
        this.name = name;
        this.status = status;
        this.numberOfIterations = numberOfIterations;
        this.lengthOfSprint = lengthOfSprint;
    }

    public ProjectClient(String name, String status, int numberOfIterations, int lengthOfSprint) {
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
