package so.ego.space.domains.meeting.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.meeting.application.MeetingMemberResisterService;
import so.ego.space.domains.meeting.application.dto.MeetingMemberResisterRequest;

@RequiredArgsConstructor
@RestController
public class MeetingMemberResisterController {

    private final MeetingMemberResisterService meetingMemberResisterService;

    //회의 참석자 추가
    @PostMapping("/meetingMember")
    public void resisterMeetingMember(@RequestBody MeetingMemberResisterRequest meetingMemberResisterRequest){
        meetingMemberResisterService.resisterMeetingMember(meetingMemberResisterRequest);
    }
}
