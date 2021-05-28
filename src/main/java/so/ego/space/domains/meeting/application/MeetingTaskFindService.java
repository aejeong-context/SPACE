package so.ego.space.domains.meeting.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.meeting.application.dto.MeetingTaskFindResponse;
import so.ego.space.domains.meeting.domain.MeetingTask;
import so.ego.space.domains.meeting.domain.MeetingTaskRepository;

@Service
@RequiredArgsConstructor
public class MeetingTaskFindService {

    private final MeetingTaskRepository meetingTaskRepository;

    //업무참조 상세보기(회의아이디)
    @Transactional
    public MeetingTaskFindResponse findOneMeetingId(Long meetingId){
        MeetingTask meetingTask = meetingTaskRepository.findById(meetingId).orElseThrow(() -> new IllegalArgumentException("Invalid meetingId Index"));
        return MeetingTaskFindResponse.builder().type(meetingTask.getType()).build();
    }

    //업무참조 상세보기(업무아이디)
    @Transactional
    public MeetingTaskFindResponse findOneTaskId(Long taskId){
        MeetingTask meetingTask = meetingTaskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Invalid taskId Index"));
        return MeetingTaskFindResponse.builder().type(meetingTask.getType()).build();
    }


}
