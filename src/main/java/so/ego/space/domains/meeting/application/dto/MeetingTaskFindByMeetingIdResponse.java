package so.ego.space.domains.meeting.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.meeting.domain.Meeting;
import so.ego.space.domains.meeting.domain.MeetingTaskType;
import so.ego.space.domains.task.application.dto.TaskFIndDetailResponse;
import so.ego.space.domains.task.damain.Task;
import so.ego.space.domains.task.damain.TaskStatus;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MeetingTaskFindByMeetingIdResponse {

    private Long meetingTaskId;
    private Long meetingId;
    private MeetingTaskType type;
    private Long taskId;
    private String taskTitle;
    private String taskContent;
    private TaskStatus taskType;
    private LocalDate taskStart_date;
    private LocalDate taskEnd_date;
}
