package so.ego.space.domains.meeting.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.meeting.application.dto.MeetingUpdateRequest;
import so.ego.space.domains.meeting.application.dto.MeetingUpdateStatusRequest;
import so.ego.space.domains.meeting.application.MeetingUpdateService;

@RequiredArgsConstructor
@RestController
public class MeetingUpdateController {

    private final MeetingUpdateService meetingUpdateService;

    //회의 내용 변경
    @PutMapping("/meeting")
    public void updateMeeting(@RequestBody MeetingUpdateRequest meetingUpdateRequest){
        meetingUpdateService.updateMeeting(meetingUpdateRequest);
    }

    //회의 상태 변경
    @PutMapping("/meeting/state")
    public void updateMeetingStatus(@RequestBody MeetingUpdateStatusRequest meetingUpdateStatusRequest){
        meetingUpdateService.updateMeetingStatus(meetingUpdateStatusRequest);
    }

}
