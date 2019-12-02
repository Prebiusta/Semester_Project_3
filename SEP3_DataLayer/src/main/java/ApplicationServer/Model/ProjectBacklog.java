package ApplicationServer.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "project_backlog")
public class ProjectBacklog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_backlog_id")
    private int projectBacklogId;

    @Column(name = "project_id")
    private int projectId;

    @Column(name = "status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_backlog_id")
    private List<UserStory> userStoryList = new ArrayList<>();

    public ProjectBacklog() {
    }

    public ProjectBacklog(int projectId, String status) {
        this.projectId = projectId;
        this.status = status;
    }

    public ProjectBacklog(int projectId, String status, List<UserStory> userStoryList) {
        this.projectId = projectId;
        this.status = status;
        this.userStoryList = userStoryList;
    }

    public int getProjectBacklogId() {
        return projectBacklogId;
    }

    public void setProjectBacklogId(int projectBacklogId) {
        this.projectBacklogId = projectBacklogId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<UserStory> getUserStoryList() {
        return userStoryList;
    }

    public void setUserStoryList(List<UserStory> userStoryList) {
        this.userStoryList = userStoryList;
    }
}
