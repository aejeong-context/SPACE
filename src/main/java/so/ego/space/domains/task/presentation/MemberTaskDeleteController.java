package so.ego.space.domains.task.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.task.application.MemberTaskDeleteService;

@RequiredArgsConstructor
@RestController
public class MemberTaskDeleteController {

    private final MemberTaskDeleteService memberTaskDeleteService;

    //업무 담당자 삭제
    @DeleteMapping("/memberTask/{memberTaskId}")
    public void deleteMemberTask(@PathVariable Long memberTaskId){
        memberTaskDeleteService.delMemberTask(memberTaskId);
    }
}
