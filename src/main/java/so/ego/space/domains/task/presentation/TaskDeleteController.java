package so.ego.space.domains.task.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.task.application.TaskDeleteService;

@RequiredArgsConstructor
@RestController
public class TaskDeleteController {

    private final TaskDeleteService taskDeleteService;

    //업무 삭제
    @DeleteMapping("/task/{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskDeleteService.deleteTask(taskId);
    }
}
