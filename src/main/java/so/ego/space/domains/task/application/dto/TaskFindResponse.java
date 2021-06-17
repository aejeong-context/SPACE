package so.ego.space.domains.task.application.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.task.damain.TaskStatus;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class TaskFindResponse {
    List<TODO> TODO;
    List<DOING> DOING;
    List<DONE> DONE;
}
