package ApplicationServer.Model;

import javax.persistence.*;

/**
 *  Entity class referencing table in the database
 */
@Entity
public class UsersInProjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "username")
    private String username;

    public UsersInProjects() {

    }

    public UsersInProjects(int projectId, String username) {
        this.projectId = projectId;
        this.username = username;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "UserInProject{" +
                "project_id='" + projectId + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
