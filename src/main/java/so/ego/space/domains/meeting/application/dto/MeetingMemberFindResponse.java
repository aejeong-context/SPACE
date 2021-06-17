package so.ego.space.domains.meeting.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.project.domain.MemberLevel;

@Getter
@Builder
@AllArgsConstructor
public class MeetingMemberFindResponse {

    private Long meetingMemberId;
    private Long meetingId;
    private Long memberId;
    private MemberLevel level;
    private String profilePath;
    private String nickname;

}
