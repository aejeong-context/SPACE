package so.ego.space.domains.project.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.project.application.MemberRegisterService;
import so.ego.space.domains.project.application.dto.MemberAddRequest;
import so.ego.space.domains.project.application.dto.MemberAddResponse;
import so.ego.space.domains.project.application.dto.MemberDropRequest;
import so.ego.space.domains.project.application.dto.MemberDropResponse;

@RequiredArgsConstructor
@RestController
public class MemberRegisterController {
    private final MemberRegisterService memberRegisterService;

    @PostMapping("/member")
    public MemberAddResponse addProjectMember(@RequestBody MemberAddRequest memberAddRequest){
        return memberRegisterService.addProjectMember(memberAddRequest);
    }

    @DeleteMapping("/member")
    public MemberDropResponse dropProjectMember(@RequestBody MemberDropRequest memberDropRequest){
        return memberRegisterService.dropProjectMember(memberDropRequest);
    }
}
