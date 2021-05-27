package so.ego.space.domains.meeting.domain.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    Optional<List<Meeting>> findAllByProjectId(Long projectId);


}
