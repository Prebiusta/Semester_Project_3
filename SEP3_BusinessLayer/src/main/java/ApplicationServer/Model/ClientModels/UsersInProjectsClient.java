package ApplicationServer.Model.ClientModels;

public class UsersInProjectsClient {
    private int projectId;
    private String username;

    public UsersInProjectsClient(int projectId, String username) {
        this.projectId = projectId;
        this.username = username;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getUsername() {
        return username;
    }
}
