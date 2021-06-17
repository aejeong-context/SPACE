package so.ego.space.domains.meeting.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.meeting.domain.MeetingTask;
import so.ego.space.domains.meeting.domain.MeetingTaskRepository;

@Service
@RequiredArgsConstructor
public class MeetingTaskDeleteService {

    private final MeetingTaskRepository meetingTaskRepository;

    //업무참조 삭제
    @Transactional
    public void deleteByMeetingTaskId(Long meetingTaskId){
        MeetingTask meetingTask = meetingTaskRepository.findById(meetingTaskId).orElseThrow(() -> new IllegalArgumentException("Invalid taskId Index"));
        meetingTaskRepository.delete(meetingTask);
    }


}
