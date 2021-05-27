package so.ego.space.domains.meeting.domain.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.meeting.domain.application.MeetingFindService;
import so.ego.space.domains.meeting.domain.application.dto.MeetingFindResponse;

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