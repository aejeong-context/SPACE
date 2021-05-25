package so.ego.space.domains.task.domain.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import so.ego.space.domains.task.domain.application.TaskFindService;
import so.ego.space.domains.task.domain.application.dto.TaskFindResponse;
import so.ego.space.domains.task.domain.damain.Task;

@RequiredArgsConstructor
@RestController
public class TaskFindController {

    private final TaskFindService taskFindService;


    @RequestMapping(value = "/task/{taskId}",method = RequestMethod.GET)
    public TaskFindResponse findOneTask(@PathVariable Long taskId){
        System.out.println(taskId+"=============");
        return taskFindService.findOneTask(taskId);
    }


}
