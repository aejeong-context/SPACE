package so.ego.space.domains.project.application;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.project.application.dto.ProjectRegisterRequest;
import so.ego.space.domains.project.application.dto.ProjectRegisterResponse;
import so.ego.space.domains.project.domain.*;
import so.ego.space.domains.user.domain.User;
import so.ego.space.domains.user.domain.UserRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProjectRegisterService {
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;
    private final UserRepository userRepository;

    @Transactional
    public ProjectRegisterResponse addProject(ProjectRegisterRequest projectRegisterRequest){
        System.out.println(projectRegisterRequest.getUser_id());

                // 프로젝트 생성
        Project project = projectRepository.save(
                Project.builder()
                        .name(projectRegisterRequest.getName())
                        .content(projectRegisterRequest.getContent())
                        .start_date(LocalDate.parse(projectRegisterRequest.getStart_date(), DateTimeFormatter.ISO_DATE))
                        .end_date(LocalDate.parse(projectRegisterRequest.getEnd_date(), DateTimeFormatter.ISO_DATE))
                        .build()
        );
        // 멤버 추가

        addMember(project, projectRegisterRequest.getUser_id());
        return ProjectRegisterResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .content(project.getContent())
                .start_date(project.getStart_date())
                .end_date(project.getEnd_date())
                .user_id(projectRegisterRequest.getUser_id())
                .build();
    }

    private void addMember(Project project, Long user_id){
        User user = userRepository.findById(user_id).orElseThrow(
                () -> new IllegalArgumentException("invalid user_id."));
        memberRepository.save(
                Member.builder()
                        .project(project)
                        .user(user)
                        .level(MemberLevel.LEADER)
                        .build()
        );
    }

}
