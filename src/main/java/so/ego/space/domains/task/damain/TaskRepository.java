package so.ego.space.domains.task.damain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<List<Task>> findByProjectId(Long projectId);

    List<Task> findByTitleIsContainingAndProjectId(String title, Long projectId);

}
