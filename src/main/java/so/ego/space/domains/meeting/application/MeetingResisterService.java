package so.ego.space.domains.meeting.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.meeting.application.dto.MeetingResisterRequest;
import so.ego.space.domains.meeting.domain.MeetingRepository;
import so.ego.space.domains.meeting.domain.Meeting;
import so.ego.space.domains.meeting.domain.MeetingCheckType;
import so.ego.space.domains.task.damain.TaskRepository;

@Service
@RequiredArgsConstructor
public class MeetingResisterService {

    private final MeetingRepository meetingRepository;
    private final TaskRepository taskRepository;
    private final MeetingTaskResisterService meetingTaskResisterService;

    //회의 생성
    public void resisterMeeting(MeetingResisterRequest meetingResisterRequest){

//         Task task = taskRepository.findById(meetingResisterRequest
//                 .getTaskId()).orElseThrow(() -> new IllegalArgumentException("Invalid Meeting Index"));

         meetingRepository.save(Meeting.builder()
                 .check(MeetingCheckType.SCHEDULE)
                 .name(meetingResisterRequest.getName())
                 .goal(meetingResisterRequest.getGoal())
                 .start_time(meetingResisterRequest.getStart_time())
                 .end_time(meetingResisterRequest.getEnd_time())
                 .build());

    }

}
