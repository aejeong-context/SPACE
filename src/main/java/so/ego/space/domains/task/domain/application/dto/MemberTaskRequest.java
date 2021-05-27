package so.ego.space.domains.task.domain.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.project.domain.domain.Project;
import so.ego.space.domains.task.domain.damain.Task;

@Getter
@Builder
@AllArgsConstructor
public class MemberTaskRequest {

    private Project projectId;
    private Task taskId;

}
