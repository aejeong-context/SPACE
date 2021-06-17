package so.ego.space.domains.meeting.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.meeting.application.MeetingMemberFindService;
import so.ego.space.domains.meeting.application.dto.MeetingMemberFindResponse;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MeetingMemberFindController {

    private final MeetingMemberFindService meetingMemberFindService;

    @GetMapping("/meetingMember/{meetingId}")
    public List<MeetingMemberFindResponse> findAllMeetingMembers(@PathVariable Long meetingId){
        return meetingMemberFindService.findAllMeetingMembers(meetingId);
    }

}
