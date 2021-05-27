package so.ego.space.domains.meeting.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.meeting.domain.MeetingRepository;
import so.ego.space.domains.meeting.domain.Meeting;

@Service
@RequiredArgsConstructor
public class MeetingDeleteService {

    private final MeetingRepository meetingRepository;

    //회의 삭제
    public void deleteMeeting(Long meetingId){
        Meeting meeting = meetingRepository.findById(meetingId).orElseThrow(() -> new IllegalArgumentException("Invalid Meeting Index"));
        meetingRepository.delete(meeting);
    }

}
