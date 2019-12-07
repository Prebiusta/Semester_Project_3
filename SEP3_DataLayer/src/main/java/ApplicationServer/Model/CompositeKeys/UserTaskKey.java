package ApplicationServer.Model.CompositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserTaskKey implements Serializable {
    @Column(name = "task_id")
    private int taskId;

    @Column(name = "username")
    private String username;

    public UserTaskKey() {
    }

    public UserTaskKey(int taskId, String username) {
        this.taskId = taskId;
        this.username = username;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserTaskKey{" +
                "taskId=" + taskId +
                ", username='" + username + '\'' +
                '}';
    }
}
