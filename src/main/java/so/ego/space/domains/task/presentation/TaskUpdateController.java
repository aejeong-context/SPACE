package so.ego.space.domains.task.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.task.application.TaskUpdateService;
import so.ego.space.domains.task.application.dto.TaskUpdateContentRequest;
import so.ego.space.domains.task.application.dto.TaskUpdateDateRequest;
import so.ego.space.domains.task.application.dto.TaskUpdateStatusRequest;

@RequiredArgsConstructor
@RestController
public class TaskUpdateController {

    private final TaskUpdateService taskUpdateService;

    @PutMapping("/task/state")
    public void updateTaskStatus(@RequestBody TaskUpdateStatusRequest taskUpdateStatusRequest){
        taskUpdateService.updateStatus(taskUpdateStatusRequest);
    }

    @PutMapping("/task/date")
    public void updateTaskDate(@RequestBody TaskUpdateDateRequest taskUpdateDateRequest){
        taskUpdateService.updateDate(taskUpdateDateRequest);
    }

    @PutMapping("/task/content")
    public void updateTaskContent(@RequestBody TaskUpdateContentRequest taskUpdateContentRequest){
        taskUpdateService.updateContent(taskUpdateContentRequest);
    }

}
