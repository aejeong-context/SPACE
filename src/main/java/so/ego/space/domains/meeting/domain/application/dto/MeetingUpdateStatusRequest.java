package so.ego.space.domains.meeting.domain.application.dto;

import lombok.Getter;
import so.ego.space.domains.meeting.domain.domain.MeetingCheckType;

@Getter
public class MeetingUpdateStatusRequest {

    private Long meetingId;
    private MeetingCheckType check;
}
