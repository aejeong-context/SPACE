package so.ego.space.domains.project.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.project.application.dto.*;
import so.ego.space.domains.project.domain.*;
import so.ego.space.domains.user.domain.User;
import so.ego.space.domains.user.domain.UserRepository;

@RequiredArgsConstructor
@Service
public class MemberRegisterService {
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;
    private final UserRepository userRepository;

    // 프로젝트 멤버 추가
    public MemberAddResponse addProjectMember(MemberAddRequest memberAddRequest) {
        User user = userRepository.findByEmail(memberAddRequest.getMember_email())
                .orElseThrow(() -> new IllegalArgumentException("invalid member_email."));
        Project project = projectRepository.findById(memberAddRequest.getProject_id())
                .orElseThrow(() -> new IllegalArgumentException("invalid project_id"));
        memberRepository.save(Member.builder()
                .project(project)
                .user(user)
                .level(MemberLevel.MEMBER)
                .build()
        );
        return MemberAddResponse.builder()
                .project_id(project.getId())
                .email(user.getEmail())
                .level(MemberLevel.MEMBER)
                .build();
    }

    public MemberDropResponse dropProjectMember(MemberDropRequest memberDropRequest){
        User user = userRepository.findByNickname(memberDropRequest.getNickname())
                .orElseThrow(() -> new IllegalArgumentException("invalid nickname."));
        Member member = memberRepository.findByUserIdAndProjectId(user.getId(), memberDropRequest.getProject_id())
                .orElseThrow(() -> new IllegalArgumentException("invalid project_id."));
        memberRepository.delete(member);
        return MemberDropResponse.builder()
                .project_id(memberDropRequest.getProject_id())
                .nickname(memberDropRequest.getNickname())
                .build();
    }
}
