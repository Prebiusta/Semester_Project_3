package ApplicationServer.JPA;

import ApplicationServer.Model.UsersInProjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersInProjectsRepository extends JpaRepository<UsersInProjects, String> {
    UsersInProjects findByUsername(String Username);
    List<UsersInProjects> findByProjectId(int id);

}
