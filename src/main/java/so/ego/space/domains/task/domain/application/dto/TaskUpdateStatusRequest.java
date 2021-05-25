package so.ego.space.domains.task.domain.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.task.domain.damain.TaskStatus;

@Getter
@Builder
@AllArgsConstructor
public class TaskUpdateStatusRequest {

    private Long taskId;
    private TaskStatus status;
}
