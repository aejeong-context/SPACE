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

    //회의 전체조회
    @GetMapping("/meetings/{projectId}")
    public List<MeetingFindResponse> findAllMeetings(@PathVariable Long projectId){
        return meetingFindService.findAllMeetings(projectId);
    }

    //회의 상세조회
    @GetMapping("/meeting/{meetingId}")
    public MeetingFindResponse findOneMeeting(@PathVariable Long meetingId){
        return meetingFindService.findOneMeeting(meetingId);
    }
}