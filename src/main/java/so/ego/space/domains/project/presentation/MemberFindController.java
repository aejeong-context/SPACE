package so.ego.space.domains.project.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.project.application.MemberFindService;
import so.ego.space.domains.project.application.dto.MemberFindResponse;
import so.ego.space.domains.project.application.dto.ProjectFindAllResponse;

@RequiredArgsConstructor
@RestController
public class MemberFindController {
    private final MemberFindService memberFindService;

    @GetMapping("/members/{project_id}")
    public MemberFindResponse findProjectMember(@PathVariable Long project_id){
        return memberFindService.findProjectMember(project_id);
    }
}
