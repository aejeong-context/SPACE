package so.ego.space.domains.meeting.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.meeting.application.MeetingMemberDeleteService;

@RequiredArgsConstructor
@RestController
public class MeetingMemberDeleteController {

    private final MeetingMemberDeleteService meetingMemberDeleteService;

    //회의 참석자 제외
    @DeleteMapping("/meetingMember/{meetingMemberId}")
    public void deleteMeetingMember(@PathVariable Long meetingMemberId){
        meetingMemberDeleteService.deleteMeetingMember(meetingMemberId);
    }

}
