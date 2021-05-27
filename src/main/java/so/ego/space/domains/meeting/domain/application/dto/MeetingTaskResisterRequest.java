package so.ego.space.domains.meeting.domain.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.meeting.domain.domain.Meeting;
import so.ego.space.domains.meeting.domain.domain.MeetingTaskType;
import so.ego.space.domains.task.domain.damain.Task;

@Getter
@Builder
@AllArgsConstructor
public class MeetingTaskResisterRequest {

    private Meeting meetingId;
    private Task taskId;
    private MeetingTaskType type;

}
