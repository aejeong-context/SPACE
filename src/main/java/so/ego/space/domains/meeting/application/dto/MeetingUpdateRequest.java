package so.ego.space.domains.meeting.application.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MeetingUpdateRequest {

    private Long meetingId;
    private String goal;
    private String name;
    private LocalDateTime start_time;
    private LocalDateTime end_time;

}
