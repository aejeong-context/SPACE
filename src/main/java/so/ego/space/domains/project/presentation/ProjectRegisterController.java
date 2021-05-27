package so.ego.space.domains.project.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.project.application.ProjectRegisterService;
import so.ego.space.domains.project.application.dto.ProjectDeleteRequest;
import so.ego.space.domains.project.application.dto.ProjectRegisterRequest;
import so.ego.space.domains.project.application.dto.ProjectRegisterResponse;

@RequiredArgsConstructor
@RestController
public class ProjectRegisterController {

    private final ProjectRegisterService projectRegisterService;

    @PostMapping("/project")
    public ProjectRegisterResponse addProject(@RequestBody ProjectRegisterRequest projectRegisterRequest){
        return projectRegisterService.addProject(projectRegisterRequest);
    }
}
