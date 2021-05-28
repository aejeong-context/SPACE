package so.ego.space.domains.task.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.task.application.MemberTaskResisterService;
import so.ego.space.domains.task.application.dto.MemberTaskResisterRequest;

@RequiredArgsConstructor
@RestController
public class MemberTaskResisterController {
    
    private final MemberTaskResisterService memberTaskResisterService;
    
    
    //업무 담당자 추가
    @PostMapping("/memberTask")
    public void resisterMemberTask(@RequestBody MemberTaskResisterRequest memberTaskResisterRequest){
        memberTaskResisterService.resisterMemberTask(memberTaskResisterRequest);
    }
}
