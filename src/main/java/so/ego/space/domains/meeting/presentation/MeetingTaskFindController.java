package so.ego.space.domains.meeting.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.meeting.application.MeetingTaskFindService;
import so.ego.space.domains.meeting.application.dto.MeetingTaskFindResponse;

@RequiredArgsConstructor
@RestController
public class MeetingTaskFindController {

    private final MeetingTaskFindService meetingTaskFindService;

    //업무참조 상세보기(업무 아이디)
    @GetMapping("/meeting/task/{taskId}")
    public MeetingTaskFindResponse findByTaskId(@PathVariable Long taskId){
        return meetingTaskFindService.findOneTaskId(taskId);
    }

    //업무참조 상세보기(회의 아이디)
    @GetMapping("/task/meeting/{meetingId}")
    public MeetingTaskFindResponse findByMeetingId(@PathVariable Long meetingId){
        return meetingTaskFindService.findOneMeetingId(meetingId);
    }


}
