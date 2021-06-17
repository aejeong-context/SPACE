package so.ego.space.domains.meeting.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.meeting.application.MeetingTaskDeleteService;

@RequiredArgsConstructor
@RestController
public class MeetingTaskDeleteController {

    private final MeetingTaskDeleteService meetingTaskDeleteService;

    //업무참조 삭제(업무아이디)
    @DeleteMapping("/meetingTask/{meetingTaskId}")
    public void deleteByMeetingTaskId(@PathVariable Long meetingTaskId){
        meetingTaskDeleteService.deleteByMeetingTaskId(meetingTaskId);
    }

}
