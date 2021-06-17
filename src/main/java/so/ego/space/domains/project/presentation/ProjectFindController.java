package so.ego.space.domains.project.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.project.application.ProjectFindService;
import so.ego.space.domains.project.application.dto.ProjectFindAllResponse;
import so.ego.space.domains.project.application.dto.ProjectFindResponse;

@RequiredArgsConstructor
@RestController
public class ProjectFindController {

    private final ProjectFindService projectFindService;

    @GetMapping("/projects/{userId}")
    public ProjectFindAllResponse findAllProject(@PathVariable Long userId){
        return projectFindService.findAllProject(userId);
    }
    @GetMapping("/project/{projectId}")
    public ProjectFindResponse findProject(@PathVariable Long projectId){
        return projectFindService.findProject(projectId);
    }


}
