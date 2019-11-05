package hello.Model;

import javax.persistence.*;

@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="task_id")
    private int taskId;
    @Column(name="sprint_user_story_id")
    private int sprintUserStoryId;
    @Column(name="description")
    private String description;
    @Column(name="status")
    private String status;

    public Tasks(){

    }

    public Tasks(int sprintUserStoryId, String description, String status) {
        this.sprintUserStoryId = sprintUserStoryId;
        this.description = description;
        this.status = status;
    }

    public Tasks(int sprintUserStoryId){
        this.sprintUserStoryId = sprintUserStoryId;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getSprintUserStoryId() {
        return sprintUserStoryId;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", sprintUserStoryId=" + sprintUserStoryId +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
