package so.ego.space.domains.meeting.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.meeting.application.dto.MeetingUpdateGoalRequest;
import so.ego.space.domains.meeting.application.dto.MeetingUpdateStatusRequest;
import so.ego.space.domains.meeting.domain.MeetingRepository;
import so.ego.space.domains.meeting.domain.Meeting;

@Service
@RequiredArgsConstructor
public class MeetingUpdateService {

    private final MeetingRepository meetingRepository;

    //회의 내용 변경
    @Transactional
    public void updateMeetingGoal(MeetingUpdateGoalRequest meetingUpdateGoalRequest){
        Meeting meeting = meetingRepository.findById(meetingUpdateGoalRequest.getMeetingId()).orElseThrow(() -> new IllegalArgumentException("Invalid Meeting Index"));
        meeting.updateMeetingGoal(meetingUpdateGoalRequest.getGoal());
    }

    //회의 상태 변경
    @Transactional
    public void updateMeetingStatus(MeetingUpdateStatusRequest meetingUpdateStatusRequest){
        Meeting meeting = meetingRepository.findById(meetingUpdateStatusRequest.getMeetingId()).orElseThrow(() -> new IllegalArgumentException("Invalid Meeting Index"));
        meeting.updateMeetingStatus(meetingUpdateStatusRequest.getCheck());
    }


}
