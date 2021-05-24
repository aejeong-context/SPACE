package so.ego.space.domains.project.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.project.application.dto.ProjectFindAllResponse;
import so.ego.space.domains.project.application.dto.ProjectFindResponse;
import so.ego.space.domains.project.domain.Member;
import so.ego.space.domains.project.domain.MemberRepository;
import so.ego.space.domains.project.domain.Project;
import so.ego.space.domains.project.domain.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectFindService {
    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;

    public ProjectFindAllResponse findAllProject(Long user_id){
        List<Project> projectList = new ArrayList<>();
        List<Member> memberList = memberRepository
                .findByUserId(user_id)
                .orElseThrow(() -> new IllegalArgumentException("invalid member_id."));

        for (Member m : memberList) projectList.add(m.getProject());

        return ProjectFindAllResponse.builder().projects(projectList).build();
    }

    public ProjectFindResponse findProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("invalid project_id."));
        return ProjectFindResponse.builder()
                .project(project)
                .build();
    }
}
