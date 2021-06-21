package so.ego.space.domains.project.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.project.application.dto.MemberAddRequest;
import so.ego.space.domains.project.application.dto.MemberAddResponse;
import so.ego.space.domains.project.application.dto.MemberDto;
import so.ego.space.domains.project.application.dto.MemberFindResponse;
import so.ego.space.domains.project.domain.Member;
import so.ego.space.domains.project.domain.MemberRepository;
import so.ego.space.domains.project.domain.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberFindService {
    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;

    // 프로젝트 팀원 조회
    public MemberFindResponse findProjectMember(Long project_id) {
        List<Member> memberList = memberRepository.findByProjectId(project_id);
        List<MemberDto> memberDtoList = new ArrayList<>();
        for (Member m : memberList) {
            memberDtoList.add(
                    MemberDto.builder()
                            .userId(m.getUser().getId())
                            .memberId(m.getId())
                    .profilePath(m.getUser().getProfile().getPath())
                    .nickname(m.getUser().getNickname())
                    .level(m.getLevel())
                    .position(m.getPosition())
                    .build()
            );
        }


        return MemberFindResponse.builder()
                .memberList(memberDtoList)
                .build();
    }

}
