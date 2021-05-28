package so.ego.space.domains.meeting.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import so.ego.space.domains.meeting.application.dto.MeetingResisterRequest;
import so.ego.space.domains.meeting.application.MeetingResisterService;

@RequiredArgsConstructor
@RestController
public class MeetingResisterController {

    public final MeetingResisterService meetingResisterService;

    //회의 생성
    @PostMapping("/meeting")
    public void resisterMeeting(@RequestBody MeetingResisterRequest meetingResisterRequest){
        meetingResisterService.resisterMeeting(meetingResisterRequest);
    }
}
