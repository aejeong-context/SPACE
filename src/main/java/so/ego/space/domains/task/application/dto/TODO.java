package so.ego.space.domains.task.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.task.damain.TaskStatus;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class TODO {
    private Long taskId;
    private String title;
    private String content;
    private TaskStatus status;
    private LocalDate start_date;
    private LocalDate end_date;
}
