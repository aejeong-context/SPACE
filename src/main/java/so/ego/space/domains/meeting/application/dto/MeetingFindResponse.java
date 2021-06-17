package so.ego.space.domains.meeting.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.meeting.domain.MeetingCheckType;
import so.ego.space.domains.meeting.domain.MeetingMember;
import so.ego.space.domains.project.domain.Member;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MeetingFindResponse {
    private Long meetingId;
    private String name;
    private String goal;
    private MeetingCheckType check;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private List<MeetingMemberFindResponse> meetingMemberFindResponseList;
}
