package so.ego.space.domains.task.application.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TaskSearchRequest {
    private String search;
}
