package so.ego.space.domains.task.damain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberTaskRepository extends JpaRepository<MemberTask, Long> {
    List<MemberTask> findByTaskId(Long TaskId);
}
