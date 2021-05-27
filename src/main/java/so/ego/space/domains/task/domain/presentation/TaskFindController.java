package so.ego.space.domains.task.domain.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import so.ego.space.domains.task.domain.application.TaskFindService;
import so.ego.space.domains.task.domain.application.dto.TaskFindResponse;
import so.ego.space.domains.task.domain.damain.Task;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TaskFindController {

    private final TaskFindService taskFindService;


    @RequestMapping(value = "/task/{taskId}",method = RequestMethod.GET)
    public TaskFindResponse findOneTask(@PathVariable Long taskId){
        return taskFindService.findOneTask(taskId);
    }

    @GetMapping("/tasks/{projectId}")
    public List<TaskFindResponse> findAllTasks(@PathVariable Long projectId){
        return taskFindService.findAllTasks(projectId);
    }

    @GetMapping("/search")
    public List<TaskFindResponse> searchTask(@RequestParam String taskTitle, @RequestParam Long projectId){
        return taskFindService.searchTask(taskTitle, projectId);
    }

}
