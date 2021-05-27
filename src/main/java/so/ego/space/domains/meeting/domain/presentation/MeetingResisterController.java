package so.ego.space.domains.meeting.domain.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import so.ego.space.domains.meeting.domain.application.MeetingResisterService;
import so.ego.space.domains.meeting.domain.application.dto.MeetingResisterRequest;

@RequiredArgsConstructor
@RestController
public class MeetingResisterController {

    public final MeetingResisterService meetingResisterService;

    //회의 생성
    @PostMapping("/resister")
    public void resisterMeeting(@RequestBody MeetingResisterRequest meetingResisterRequest){
        meetingResisterService.resisterMeeting(meetingResisterRequest);
    }
}
