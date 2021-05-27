package so.ego.space.domains.task.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class TaskUpdateDateRequest {

    private Long taskId;
    private LocalDate start_date;
    private LocalDate end_date;

}
