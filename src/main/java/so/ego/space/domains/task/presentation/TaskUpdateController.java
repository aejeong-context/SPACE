package so.ego.space.domains.task.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.task.application.TaskUpdateService;
import so.ego.space.domains.task.application.dto.TaskUpdateContentRequest;
import so.ego.space.domains.task.application.dto.TaskUpdateDateRequest;
import so.ego.space.domains.task.application.dto.TaskUpdateRequest;
import so.ego.space.domains.task.application.dto.TaskUpdateStatusRequest;

@RequiredArgsConstructor
@RestController
public class TaskUpdateController {

    private final TaskUpdateService taskUpdateService;

    //업무 상태변경
    @PutMapping("/task/state")
    public void updateTaskStatus(@RequestBody TaskUpdateStatusRequest taskUpdateStatusRequest){
        taskUpdateService.updateStatus(taskUpdateStatusRequest);
    }

    //업무 날짜변경
    @PutMapping("/task/date")
    public void updateTaskDate(@RequestBody TaskUpdateDateRequest taskUpdateDateRequest){
        taskUpdateService.updateDate(taskUpdateDateRequest);
    }

    //업무 내용변경
    @PutMapping("/task/content")
    public void updateTaskContent(@RequestBody TaskUpdateContentRequest taskUpdateContentRequest){
        taskUpdateService.updateContent(taskUpdateContentRequest);
    }

    //전체 변경
    @PutMapping("/task")
    public void updateTask(@RequestBody(required = false) TaskUpdateRequest taskUpdateRequest){
        taskUpdateService.updateTask(taskUpdateRequest);
    }

}
