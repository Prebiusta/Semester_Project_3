package ApplicationServer.JPA;

import ApplicationServer.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findAllByStatus(String string);
    List<Project> findByProjectId(int id);
}



