package so.ego.space.domains.meeting.domain.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.meeting.domain.application.MeetingResisterService;
import so.ego.space.domains.meeting.domain.application.dto.MeetingResisterRequest;
import so.ego.space.domains.meeting.domain.application.dto.MeetingUpdateRequest;

@RequiredArgsConstructor
@RestController
public class MeetingResisterController {

    public final MeetingResisterService meetingResisterService;

    //회의 생성
    @PostMapping("/resister")
    public void resisterMeeting(MeetingResisterRequest meetingResisterRequest){
        meetingResisterService.resisterMeeting(meetingResisterRequest);
    }
}
