package so.ego.space.domains.meeting.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.meeting.application.dto.MeetingMemberResisterRequest;
import so.ego.space.domains.meeting.domain.Meeting;
import so.ego.space.domains.meeting.domain.MeetingMember;
import so.ego.space.domains.meeting.domain.MeetingMemberRepository;
import so.ego.space.domains.meeting.domain.MeetingRepository;
import so.ego.space.domains.project.domain.Member;
import so.ego.space.domains.project.domain.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingMemberResisterService {

    private final MeetingMemberRepository meetingMemberRepository;
    private final MeetingRepository meetingRepository;
    private final MemberRepository memberRepository;

    //참석자 추가
    @Transactional
    public void resisterMeetingMember(MeetingMemberResisterRequest meetingMemberResisterRequest){

        Meeting meeting = meetingRepository.findById(meetingMemberResisterRequest.getMeetingId()).orElseThrow(() -> new IllegalArgumentException("Invalid meetingId Index"));

        List<Long> memberIds = meetingMemberResisterRequest.getMemberId();
        List<Member> member = memberRepository.findAllById(memberIds);

        for(int i=0; i<memberIds.size(); i++){
            meetingMemberRepository.save(MeetingMember.builder()
                    .meeting(meeting)
                    .member(member.get(i))
                    .build());
        }
//        List<Member> memberList = memberRepository.findAllById(meetingMemberResisterRequest.getMemberId());
//                findById(meetingMemberResisterRequest.getMemberId()).orElseThrow(() -> new IllegalArgumentException("Invalid memberId Index"));


    }
}
