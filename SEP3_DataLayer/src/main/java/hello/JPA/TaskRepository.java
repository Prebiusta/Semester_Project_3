package hello.JPA;

import hello.Model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Integer> {

    List<Tasks> findAllByStatus(String string);
    List<Tasks> findByTaskId(int id);
}
