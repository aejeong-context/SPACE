package so.ego.space.domains.task.domain.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.task.domain.application.TaskResisterService;
import so.ego.space.domains.task.domain.application.dto.TaskResisterRequest;

@RequiredArgsConstructor
@RestController
public class TaskResisterController {

    private final TaskResisterService taskResisterService;

    @PostMapping("/resistertask")
    public void resisterTask(@RequestBody TaskResisterRequest taskResisterRequest){
        taskResisterService.resisterTask(taskResisterRequest);
    }

}
