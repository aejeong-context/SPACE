package so.ego.space.domains.task.domain.damain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<List<Task>> findByProjectId(Long projectId);

//    @Query(value= "select * from task t where t.title like %:taskTitle%", nativeQuery = true)
//    List<Task> findByTitleLike(@Param("taskTitle") String taskTitle);
        List<Task> findByTitleIsContainingAndProjectId(String title, Long projectId);

}
