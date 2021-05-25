package so.ego.space.domains.project.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.project.application.dto.MemberUpdatePositionResponse;
import so.ego.space.domains.project.application.dto.MemberUpdatePosotionRequest;
import so.ego.space.domains.project.domain.Member;
import so.ego.space.domains.project.domain.MemberRepository;
import so.ego.space.domains.project.domain.Project;
import so.ego.space.domains.project.domain.ProjectRepository;
import so.ego.space.domains.user.domain.User;
import so.ego.space.domains.user.domain.UserRepository;

@RequiredArgsConstructor
@Service
public class MemberUpdateService {
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;
    private final UserRepository userRepository;

    @Transactional
    public MemberUpdatePositionResponse updatePosition(MemberUpdatePosotionRequest memberUpdatePosotionRequest){
        Project project = projectRepository.findById(memberUpdatePosotionRequest.getProject_id())
                .orElseThrow(() -> new IllegalArgumentException("invalid project_id"));
        User user = userRepository.findByNickname(memberUpdatePosotionRequest.getNickname())
                .orElseThrow(() -> new IllegalArgumentException("invalid nickname."));
        Member member = memberRepository.findByUserIdAndProjectId(user.getId(), project.getId())
                .orElseThrow(() -> new IllegalArgumentException("invalid project_id and nickname."));
        member.updatePosition(memberUpdatePosotionRequest.getPosition());
        return MemberUpdatePositionResponse.builder()
                .nickname(memberUpdatePosotionRequest.getNickname())
                .position(memberUpdatePosotionRequest.getPosition())
                .build();
    }
}
