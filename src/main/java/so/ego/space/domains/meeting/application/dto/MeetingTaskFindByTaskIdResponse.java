package so.ego.space.domains.meeting.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.meeting.domain.MeetingCheckType;
import so.ego.space.domains.meeting.domain.MeetingTaskType;
import so.ego.space.domains.task.damain.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class MeetingTaskFindByTaskIdResponse {
    private Long taskId;
    private MeetingTaskType type;
    private Long meetingId;
    private String meetingName;
    private String meetingGoal;
    private MeetingCheckType meetingCheckType;
    private LocalDateTime meetingStart_date;
    private LocalDateTime meetingEnd_date;
}
