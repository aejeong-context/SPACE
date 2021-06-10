package so.ego.space.domains.task.application.dto;

import lombok.Getter;
import so.ego.space.domains.task.damain.MemberTask;
import so.ego.space.domains.task.damain.TaskStatus;

import java.time.LocalDate;
import java.util.List;

@Getter
public class TaskUpdateRequest {

    private Long taskId;
    private String title;
    private String content;
    private LocalDate start_date;
    private LocalDate end_date;
    private TaskStatus status;
    private List<Long> memberIdList;

}
