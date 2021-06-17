package so.ego.space.domains.meeting.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.project.domain.Member;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MeetingMemberResisterRequest {

    private Long meetingId;
    private List<Long> memberId;

}
