package so.ego.space.domains.meeting.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.meeting.domain.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingDeleteService {

    private final MeetingRepository meetingRepository;
    private final MeetingTaskRepository meetingTaskRepository;
    private final MeetingMemberRepository meetingMemberRepository;

    //회의 삭제
    @Transactional
    public void deleteMeeting(Long meetingId){
        List<MeetingTask> meetingTasks = meetingTaskRepository.findByMeetingId(meetingId);
        meetingTaskRepository.deleteAll(meetingTasks);
        List<MeetingMember> meetingMembers = meetingMemberRepository.findByMeetingId(meetingId);
        meetingMemberRepository.deleteAll(meetingMembers);
        Meeting meeting = meetingRepository.findById(meetingId).orElseThrow(() -> new IllegalArgumentException("Invalid Meeting Index"));
        meetingRepository.delete(meeting);
    }

}
