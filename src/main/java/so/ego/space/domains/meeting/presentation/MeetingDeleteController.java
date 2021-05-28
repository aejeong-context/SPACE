package so.ego.space.domains.meeting.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.meeting.application.MeetingDeleteService;

@RequiredArgsConstructor
@RestController
public class MeetingDeleteController {

    private final MeetingDeleteService meetingDeleteService;


    //회의 삭제
    @DeleteMapping("/meeting/{meetingId}")
    public void deleteMeeting(@PathVariable Long meetingId){
        meetingDeleteService.deleteMeeting(meetingId);
    }
}
