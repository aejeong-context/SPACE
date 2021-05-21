package so.ego.space.domains.meeting.domain.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.meeting.domain.application.dto.MeetingFindResponse;
import so.ego.space.domains.meeting.domain.application.dto.MeetingResisterRequest;
import so.ego.space.domains.meeting.domain.domain.Meeting;
import so.ego.space.domains.meeting.domain.domain.MeetingCheckType;
import so.ego.space.domains.meeting.domain.domain.MeetingRepository;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingResisterService {

    private final MeetingRepository meetingRepository;

    //회의 생성
    public void resisterMeeting(MeetingResisterRequest meetingResisterRequest){
         meetingRepository.save(Meeting.builder()
                 .check(MeetingCheckType.SCHEDULE)
                 .name(meetingResisterRequest.getName())
                 .goal(meetingResisterRequest.getGoal())
                 .start_time(meetingResisterRequest.getStart_time())
                 .end_time(meetingResisterRequest.getEnd_time()).build());
    }
}
