package so.ego.space.domains.meeting.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingTaskRepository extends JpaRepository<MeetingTask, Long> {

    List<MeetingTask> findByMeetingId(Long meetingId);
    List<MeetingTask> findByTaskId(Long taskId);

}
