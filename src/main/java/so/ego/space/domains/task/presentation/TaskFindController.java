package so.ego.space.domains.task.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import so.ego.space.domains.task.application.TaskFindService;
import so.ego.space.domains.task.application.dto.TaskFIndDetailResponse;
import so.ego.space.domains.task.application.dto.TaskFindResponse;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TaskFindController {

    private final TaskFindService taskFindService;


    //업무 상세보기
    @RequestMapping(value = "/task/{taskId}",method = RequestMethod.GET)
    public TaskFIndDetailResponse findOneTask(@PathVariable Long taskId){
        return taskFindService.findOneTask(taskId);
    }

    //업무 리스트
    @GetMapping("/tasks/{projectId}")
    public TaskFindResponse findAllTasks(@PathVariable Long projectId){
        return taskFindService.findAllTasks(projectId);
    }

    //업무 검색
    @GetMapping("/taskSearch")
    public List<TaskFIndDetailResponse> searchTask(@RequestParam String searchTaskTitle, @RequestParam Long projectId){
        return taskFindService.searchTask(searchTaskTitle, projectId);
    }


}
