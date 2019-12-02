package ApplicationServer.Model;

import javax.persistence.*;

@Entity(name = "user_story")
public class UserStory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_story_id")
    private int userStoryId;

    @Column(name = "project_backlog_id")
    private int projectBacklogId;

    @Column(name = "priority")
    private String priority;

    @Column(name = "description")
    private String description;

    @Column(name = "difficulty")
    private int difficulty;

    @Column(name = "status")
    private String status;

    public UserStory() {
    }

    public UserStory(int projectBacklogId, String priority, String description, int difficulty, String status) {
        this.projectBacklogId = projectBacklogId;
        this.priority = priority;
        this.description = description;
        this.difficulty = difficulty;
        this.status = status;
    }

    public int getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(int userStoryId) {
        this.userStoryId = userStoryId;
    }

    public int getProjectBacklogId() {
        return projectBacklogId;
    }

    public void setProjectBacklogId(int projectBacklogId) {
        this.projectBacklogId = projectBacklogId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
