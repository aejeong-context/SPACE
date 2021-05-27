package so.ego.space.domains.meeting.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.meeting.application.dto.MeetingFindResponse;
import so.ego.space.domains.meeting.application.MeetingFindService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MeetingFindController {

    private final MeetingFindService meetingFindService;

    @GetMapping("/meetings/{taskId}")
    public List<MeetingFindResponse> findAllMeetings(@PathVariable Long taskId){
        return meetingFindService.findAllMeetings(taskId);
    }

    @GetMapping("/meeting/{meetingId}")
    public MeetingFindResponse findOneMeeting(Long meetingId){
        return meetingFindService.findOneMeeting(meetingId);
    }
}