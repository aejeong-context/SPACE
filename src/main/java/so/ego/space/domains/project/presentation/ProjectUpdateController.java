package so.ego.space.domains.project.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.project.application.ProjectUpdateService;
import so.ego.space.domains.project.application.dto.ProjectDeleteRequest;
import so.ego.space.domains.project.application.dto.ProjectUpdateRequest;
import so.ego.space.domains.project.application.dto.ProjectUpdateResponse;

@RequiredArgsConstructor
@RestController
public class ProjectUpdateController {
    private final ProjectUpdateService projectUpdateService;

    @PutMapping("/project")
    public ProjectUpdateResponse updateProject(@RequestBody ProjectUpdateRequest projectUpdateRequest){
        return projectUpdateService.updateProject(projectUpdateRequest);
    }

    @DeleteMapping("/project")
    public void deleteProject(@RequestBody ProjectDeleteRequest projectDeleteRequest){
        projectUpdateService.deleteProject(projectDeleteRequest);
    }
}
