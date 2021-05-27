package so.ego.space.domains.meeting.application.dto;

import lombok.Getter;
import so.ego.space.domains.meeting.domain.MeetingCheckType;

@Getter
public class MeetingUpdateStatusRequest {

    private Long meetingId;
    private MeetingCheckType check;
}
