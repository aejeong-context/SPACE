package so.ego.space.domains.meeting.domain.application.dto;

import lombok.Getter;
import so.ego.space.domains.meeting.domain.domain.MeetingCheckType;

import java.time.LocalDateTime;

@Getter
public class MeetingUpdateGoalRequest {

    private Long meetingId;
    private String goal;

}
