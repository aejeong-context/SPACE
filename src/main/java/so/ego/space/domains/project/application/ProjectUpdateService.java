package so.ego.space.domains.project.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.project.application.dto.ProjectDeleteRequest;
import so.ego.space.domains.project.application.dto.ProjectUpdateRequest;
import so.ego.space.domains.project.application.dto.ProjectUpdateResponse;
import so.ego.space.domains.project.domain.*;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectUpdateService {
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;

    // 프로젝트 주인 확인
    private boolean isLeader(Project project, Long user_id){
        Member member = memberRepository.findByUserIdAndProjectId(user_id, project.getId())
                .orElseThrow(() -> new IllegalArgumentException("invalid user_id"));
        return member.getLevel().equals(MemberLevel.LEADER) ? true : false;
    }

    // 프로젝트 변경
    @Transactional
    public ProjectUpdateResponse updateProject(ProjectUpdateRequest projectUpdateRequest){
        Project project  = projectRepository.findById(projectUpdateRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("invalid project_id."));
        if(isLeader(project, projectUpdateRequest.getUser_id())){
            project.setName(projectUpdateRequest.getName());
            project.setContent(projectUpdateRequest.getContent());
            project.setStart_date(projectUpdateRequest.getStart_date());
            project.setEnd_date(projectUpdateRequest.getEnd_date());
        }
        return ProjectUpdateResponse.builder()
                .name(project.getName())
                .content(project.getContent())
                .start_date(project.getStart_date())
                .end_date(project.getEnd_date())
                .build();
    }

    // 프로젝트 삭제
    @Transactional
    public void deleteProject(ProjectDeleteRequest projectDeleteRequest){
        Project project = projectRepository.findById(projectDeleteRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("invalid project_id."));
        if(isLeader(project, projectDeleteRequest.getUser_id())) {
            memberRepository.deleteByProjectId(project.getId());
            projectRepository.delete(project);
        }
    }
}
