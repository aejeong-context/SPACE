package so.ego.space.domains.task.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.task.application.MemberTaskFindService;
import so.ego.space.domains.task.application.dto.MemberTaskFindResponse;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberTaskFindController {
    private final MemberTaskFindService memberTaskFindService;

    @GetMapping("/memberTask/{taskId}")
    public List<MemberTaskFindResponse> findAllMemberTasks(@PathVariable Long taskId){
        return memberTaskFindService.findAllMemberTask(taskId);
    }
}
