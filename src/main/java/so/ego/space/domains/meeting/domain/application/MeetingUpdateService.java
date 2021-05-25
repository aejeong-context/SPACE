package so.ego.space.domains.meeting.domain.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.meeting.domain.application.dto.MeetingResisterRequest;
import so.ego.space.domains.meeting.domain.application.dto.MeetingUpdateRequest;
import so.ego.space.domains.meeting.domain.domain.Meeting;
import so.ego.space.domains.meeting.domain.domain.MeetingCheckType;
import so.ego.space.domains.meeting.domain.domain.MeetingRepository;

@Service
@RequiredArgsConstructor
public class MeetingUpdateService {

    private final MeetingRepository meetingRepository;

    //회의 수정
    public void updateMeeting(MeetingUpdateRequest meetingUpdateRequest){
        Meeting meeting = meetingRepository.findById(meetingUpdateRequest.getMeetingId()).orElseThrow(() -> new IllegalArgumentException("Invalid Meeting Index"));
        meeting.updateMeeting(meetingUpdateRequest.getGoal(), meetingUpdateRequest.getCheck());
    }

    //회의 상태 변경
    public void updateMeetingStatus(MeetingUpdateRequest meetingUpdateRequest){
        Meeting meeting = meetingRepository.findById(meetingUpdateRequest.getMeetingId()).orElseThrow(() -> new IllegalArgumentException("Invalid Meeting Index"));
        meeting.updateMeetingStatus(MeetingCheckType.COMPLETION);
    }


}
