package so.ego.space.domains.meeting.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.meeting.application.dto.MeetingUpdateRequest;
import so.ego.space.domains.meeting.application.dto.MeetingUpdateStatusRequest;
import so.ego.space.domains.meeting.domain.MeetingRepository;
import so.ego.space.domains.meeting.domain.Meeting;

@Service
@RequiredArgsConstructor
public class MeetingUpdateService {

    private final MeetingRepository meetingRepository;

    //회의 내용 변경
    @Transactional
    public void updateMeeting(MeetingUpdateRequest meetingUpdateRequest){
        Meeting meeting = meetingRepository.findById(meetingUpdateRequest.getMeetingId()).orElseThrow(() -> new IllegalArgumentException("Invalid Meeting Index"));
        meeting.updateMeeting(meetingUpdateRequest.getName(),meetingUpdateRequest.getGoal(),meetingUpdateRequest.getStart_time(),meetingUpdateRequest.getEnd_time());
    }

    //회의 상태 변경
    @Transactional
    public void updateMeetingStatus(MeetingUpdateStatusRequest meetingUpdateStatusRequest){
        Meeting meeting = meetingRepository.findById(meetingUpdateStatusRequest.getMeetingId()).orElseThrow(() -> new IllegalArgumentException("Invalid Meeting Index"));
        meeting.updateMeetingStatus(meetingUpdateStatusRequest.getCheck());
    }

}
