package ApplicationServer.Model.DataLayerModels;

public class UserStoryDataLayer {
    private int userStoryId;
    private int projectBacklogId;
    private String priority;
    private String description;
    private int difficulty;
    private String status;

    public UserStoryDataLayer() {
    }

    public UserStoryDataLayer(int userStoryId, int projectBacklogId, String priority, String description, int difficulty, String status) {
        this.userStoryId = userStoryId;
        this.projectBacklogId = projectBacklogId;
        this.priority = priority;
        this.description = description;
        this.difficulty = difficulty;
        this.status = status;
    }

    public int getUserStoryId() {
        return userStoryId;
    }

    public int getProjectBacklogId() {
        return projectBacklogId;
    }

    public String getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getStatus() {
        return status;
    }
}
