package so.ego.space.domains.project.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.project.application.MemberRegisterService;
import so.ego.space.domains.project.application.MemberUpdateService;
import so.ego.space.domains.project.application.dto.MemberUpdatePositionResponse;
import so.ego.space.domains.project.application.dto.MemberUpdatePosotionRequest;

@RequiredArgsConstructor
@RestController
public class MemberUpdateController {
    private final MemberUpdateService memberUpdateService;

    @PutMapping("/member/position")
    public MemberUpdatePositionResponse updatePosition(@RequestBody MemberUpdatePosotionRequest memberUpdatePosotionRequest){
        return memberUpdateService.updatePosition(memberUpdatePosotionRequest);
    }
}
