package so.ego.space.domains.task.domain.application.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.task.domain.damain.TaskStatus;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor

public class TaskFindResponse {
    private String title;
    private String content;
    private TaskStatus status;
    private LocalDate start_date;
    private LocalDate end_date;
}
