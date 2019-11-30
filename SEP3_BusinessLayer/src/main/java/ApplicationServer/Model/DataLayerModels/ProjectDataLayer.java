package ApplicationServer.Model.DataLayerModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectDataLayer {
    @JsonProperty
    private int projectId;
    @JsonProperty
    private String name;
    @JsonProperty
    private String status;
    @JsonProperty
    private int numberOfIterations;
    @JsonProperty
    private int lengthOfSprint;

    public ProjectDataLayer(){

    }

    public ProjectDataLayer(int projectId, String name, String status, int numberOfIterations, int lengthOfSprint) {
        this.projectId = projectId;
        this.name = name;
        this.status = status;
        this.numberOfIterations = numberOfIterations;
        this.lengthOfSprint = lengthOfSprint;
    }

    public ProjectDataLayer(String name, String status, int numberOfIterations, int lengthOfSprint) {
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
