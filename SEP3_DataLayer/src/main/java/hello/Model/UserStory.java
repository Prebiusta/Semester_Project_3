package hello.Model;

public class UserStory {
    private int userStoryId;
    private int projectBacklogId;
    private String priority;
    private String description;
    private int difficulty;
    private String status;

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

    @Override
    public String toString() {
        return "UserStory{" +
                "userStoryId=" + userStoryId +
                ", projectBacklogId=" + projectBacklogId +
                ", priority='" + priority + '\'' +
                ", description='" + description + '\'' +
                ", difficulty=" + difficulty +
                ", status='" + status + '\'' +
                '}';
    }
}
