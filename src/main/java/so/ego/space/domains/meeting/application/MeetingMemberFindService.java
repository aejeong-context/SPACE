package so.ego.space.domains.meeting.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.meeting.application.dto.MeetingMemberFindResponse;
import so.ego.space.domains.meeting.domain.MeetingMember;
import so.ego.space.domains.meeting.domain.MeetingMemberRepository;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingMemberFindService {

    private final MeetingMemberRepository meetingMemberRepository;

    public List<MeetingMemberFindResponse> findAllMeetingMembers(Long meetingId){

        List<MeetingMemberFindResponse> meetingMemberFindResponses = new LinkedList<>();
        List<MeetingMember> meetingMemberList = meetingMemberRepository.findByMeetingId(meetingId);

        for( MeetingMember meetingMember : meetingMemberList){
            meetingMemberFindResponses.add(MeetingMemberFindResponse.builder()
                    .meetingMemberId(meetingMember.getId())
                    .meetingId(meetingMember.getMeeting().getId())
                    .memberId(meetingMember.getMember().getId())
                    .level(meetingMember.getMember().getLevel())
                    .nickname(meetingMember.getMember().getUser().getNickname())
                    .profilePath(meetingMember.getMember().getUser().getProfile().getPath())
                    .build());


        }
        return meetingMemberFindResponses;
    }

}
