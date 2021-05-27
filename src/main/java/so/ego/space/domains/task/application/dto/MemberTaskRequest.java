package so.ego.space.domains.task.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.project.domain.Project;
import so.ego.space.domains.task.damain.Task;

@Getter
@Builder
@AllArgsConstructor
public class MemberTaskRequest {

    private Project projectId;
    private Task taskId;

}
