package so.ego.space.domains.meeting.domain.application.dto;

import lombok.Getter;
import so.ego.space.domains.meeting.domain.domain.MeetingCheckType;

import java.time.LocalDateTime;

@Getter
public class MeetingFindRequest {

    private String name;
    private String goal;
    private MeetingCheckType check;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
}
