package so.ego.space.domains.meeting.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.meeting.domain.Meeting;
import so.ego.space.domains.meeting.domain.MeetingTaskType;
import so.ego.space.domains.task.damain.Task;

@Getter
@Builder
@AllArgsConstructor
public class MeetingTaskResisterRequest {

    private Meeting meetingId;
    private Task taskId;
    private MeetingTaskType type;

}
