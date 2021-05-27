package so.ego.space.domains.meeting.application.dto;

import lombok.Getter;

@Getter
public class MeetingUpdateGoalRequest {

    private Long meetingId;
    private String goal;

}
