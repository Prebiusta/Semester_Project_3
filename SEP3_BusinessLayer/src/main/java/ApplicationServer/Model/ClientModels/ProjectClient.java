package ApplicationServer.Model.ClientModels;

import java.util.List;

public class ProjectClient {

    private int projectId;
    private String name;
    private String status;
    private int numberOfIterations;
    private int lengthOfSprint;
    private List<String> admins;

    public ProjectClient(){

    }

    public ProjectClient(int projectId, String name, String status, int numberOfIterations, int lengthOfSprint, List<String> admins) {
        this.projectId = projectId;
        this.name = name;
        this.status = status;
        this.numberOfIterations = numberOfIterations;
        this.lengthOfSprint = lengthOfSprint;
        this.admins = admins;
    }

    public ProjectClient(String name, String status, int numberOfIterations, int lengthOfSprint, List<String> admins) {
        this.name = name;
        this.status = status;
        this.numberOfIterations = numberOfIterations;
        this.lengthOfSprint = lengthOfSprint;
        this.admins = admins;
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

    public List<String> getAdmins() {
        return admins;
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
