package ApplicationServer.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "sprint_backlog")
public class SprintBacklog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sprint_backlog_id")
    private int sprintBacklogId;

    @Column(name = "sprint_id")
    private int sprintId;

    public SprintBacklog() {
    }

    public int getSprintBacklogId() {
        return sprintBacklogId;
    }

    public void setSprintBacklogId(int sprintBacklogId) {
        this.sprintBacklogId = sprintBacklogId;
    }

    public int getSprintId() {
        return sprintId;
    }

    public void setSprintId(int sprintId) {
        this.sprintId = sprintId;
    }

}
