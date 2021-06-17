package so.ego.space.domains.meeting.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingMemberRepository extends JpaRepository<MeetingMember, Long> {
    List<MeetingMember> findByMeetingId(Long meetingId);
}
