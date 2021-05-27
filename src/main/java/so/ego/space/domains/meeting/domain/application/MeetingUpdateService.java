package so.ego.space.domains.meeting.domain.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.meeting.domain.application.dto.MeetingUpdateGoalRequest;
import so.ego.space.domains.meeting.domain.application.dto.MeetingUpdateStatusRequest;
import so.ego.space.domains.meeting.domain.domain.Meeting;
import so.ego.space.domains.meeting.domain.domain.MeetingRepository;

@Service
@RequiredArgsConstructor
public class MeetingUpdateService {

    private final MeetingRepository meetingRepository;

    //회의 내용 변경
    public void updateMeetingGoal(MeetingUpdateGoalRequest meetingUpdateGoalRequest){
        Meeting meeting = meetingRepository.findById(meetingUpdateGoalRequest.getMeetingId()).orElseThrow(() -> new IllegalArgumentException("Invalid Meeting Index"));
        meeting.updateMeetingGoal(meetingUpdateGoalRequest.getGoal());
    }

    //회의 상태 변경
    public void updateMeetingStatus(MeetingUpdateStatusRequest meetingUpdateStatusRequest){
        Meeting meeting = meetingRepository.findById(meetingUpdateStatusRequest.getMeetingId()).orElseThrow(() -> new IllegalArgumentException("Invalid Meeting Index"));
        meeting.updateMeetingStatus(meetingUpdateStatusRequest.getCheck());
    }


}
