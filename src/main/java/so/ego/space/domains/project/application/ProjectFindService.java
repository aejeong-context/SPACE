package so.ego.space.domains.project.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.project.application.dto.MemberDto;
import so.ego.space.domains.project.application.dto.ProjectDetailDto;
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
    private final ProjectRepository projectRepository;

    public ProjectFindAllResponse findAllProject(Long user_id){
        // 유저 ID로 프로젝트 ID 리스트를 가져온다.
        List<ProjectDetailDto> projectDetailDtoList = new ArrayList<>();


        List<Project> projectList1 = projectRepository.findMyProject(user_id);

        for(Project project : projectList1) {
            List<MemberDto> memberDtoList = new ArrayList<>();

            for(Member member : project.getMemberList()) {
                memberDtoList.add(MemberDto.builder().memberId(member.getId())
                        .profilePath(member.getUser().getProfile().getPath()).position(member.getPosition()).nickname(member.getUser().getNickname()).level(member.getLevel()).build());
            }
            projectDetailDtoList
                    .add(ProjectDetailDto.builder().member(memberDtoList).start_date(project.getStart_date()).end_date(project.getEnd_date()).name(project.getName()).content(project.getContent()).id(project.getId()).build());

        }

        return ProjectFindAllResponse.builder()
                .projects(projectDetailDtoList).build();
    }

    public ProjectFindResponse findProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("invalid project_id."));
        List<MemberDto> memberList = new ArrayList<>();

        for (Member member : project.getMemberList()) {
            memberList.add(MemberDto.builder()
                    .memberId(member.getId())
                    .level(member.getLevel())
                    .nickname(member.getUser().getNickname())
                    .position(member.getPosition())
                    .profilePath(member.getUser().getProfile().getPath())
                    .build());
        }
        return ProjectFindResponse.builder()
                .project(project)
                .members(memberList)
                .build();
    }
}
