package so.ego.space.domains.meeting.domain.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.meeting.domain.application.MeetingUpdateService;
import so.ego.space.domains.meeting.domain.application.dto.MeetingUpdateRequest;

@RequiredArgsConstructor
@RestController
public class MeetingUpdateController {

    private final MeetingUpdateService meetingUpdateService;

    @PutMapping("/meeting")
    public void updateMeeting(@RequestBody MeetingUpdateRequest meetingUpdateRequest){
        meetingUpdateService.updateMeeting(meetingUpdateRequest);
    }

}
