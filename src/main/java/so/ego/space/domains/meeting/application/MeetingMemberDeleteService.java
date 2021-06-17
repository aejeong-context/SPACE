package so.ego.space.domains.meeting.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.meeting.domain.MeetingMember;
import so.ego.space.domains.meeting.domain.MeetingMemberRepository;

@Service
@RequiredArgsConstructor
public class MeetingMemberDeleteService {

    private final MeetingMemberRepository meetingMemberRepository;

    //참석자 제외
    @Transactional
    public void deleteMeetingMember(Long meetingMemberId){
        MeetingMember meetingMember = meetingMemberRepository.findById(meetingMemberId).orElseThrow(() -> new IllegalArgumentException("Invalid meetingMemberId Index"));
        meetingMemberRepository.delete(meetingMember);
    }
}
