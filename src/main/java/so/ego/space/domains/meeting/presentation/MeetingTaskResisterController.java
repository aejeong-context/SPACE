package so.ego.space.domains.meeting.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.meeting.application.MeetingTaskResisterService;
import so.ego.space.domains.meeting.application.dto.MeetingTaskResisterRequest;

@RequiredArgsConstructor
@RestController
public class MeetingTaskResisterController {

    private final MeetingTaskResisterService meetingTaskResisterService;

    //업무참조 생성
    @PostMapping("/meetingTask")
    public void resisterMeetingTask(@RequestBody MeetingTaskResisterRequest meetingTaskResisterRequest){
        meetingTaskResisterService.resisterMeetingTask(meetingTaskResisterRequest);
    }
}
