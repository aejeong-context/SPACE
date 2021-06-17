package so.ego.space.domains.task.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TaskUpdateContentRequest {

    private Long taskId;
    private String title;
    private String content;

}
