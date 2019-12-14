package ApplicationServer.Model.ClientModels;


import ApplicationServer.Model.DataLayerModels.UserStoryDataLayer;

public class SprintUserStoryClient {
    private int sprintUserStoryId;

    private UserStoryDataLayer userStoryClient;

    private int sprintBacklogId;

    public SprintUserStoryClient() {
    }

    public SprintUserStoryClient(int sprintUserStoryId, UserStoryDataLayer userStoryClient, int sprintBacklogId) {
        this.sprintUserStoryId = sprintUserStoryId;
        this.userStoryClient = userStoryClient;
        this.sprintBacklogId = sprintBacklogId;
    }

    public int getSprintUserStoryId() {
        return sprintUserStoryId;
    }

    public void setSprintUserStoryId(int sprintUserStoryId) {
        this.sprintUserStoryId = sprintUserStoryId;
    }

    public UserStoryDataLayer getUserStoryClient() {
        return userStoryClient;
    }

    public void setUserStoryClient(UserStoryDataLayer userStoryClient) {
        this.userStoryClient = userStoryClient;
    }

    public int getSprintBacklogId() {
        return sprintBacklogId;
    }

    public void setSprintBacklogId(int sprintBacklogId) {
        this.sprintBacklogId = sprintBacklogId;
    }
}
