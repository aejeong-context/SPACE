package so.ego.space.domains.task.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.task.application.TaskResisterService;
import so.ego.space.domains.task.application.dto.TaskResisterRequest;

@RequiredArgsConstructor
@RestController
public class TaskResisterController {

    private final TaskResisterService taskResisterService;

    @PostMapping("/resistertask")
    public void resisterTask(@RequestBody TaskResisterRequest taskResisterRequest){
        taskResisterService.resisterTask(taskResisterRequest);
    }

}
