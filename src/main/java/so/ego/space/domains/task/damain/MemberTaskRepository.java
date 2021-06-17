package so.ego.space.domains.task.damain;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import so.ego.space.domains.project.domain.Member;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MemberTaskRepository extends JpaRepository<MemberTask, Long> {
    List<MemberTask> findByTaskId(Long taskId);
}
