package so.ego.space.domains.task.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.task.damain.TaskStatus;

@Getter
@Builder
@AllArgsConstructor
public class TaskUpdateStatusRequest {

    private Long taskId;
    private TaskStatus status;
}
