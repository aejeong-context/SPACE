package so.ego.space.domains.meeting.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MeetingMemberResisterRequest {

    private Long meetingId;
    private Long memberId;

}
