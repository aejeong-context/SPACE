package so.ego.space.domains.project.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.project.domain.Member;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MemberFindResponse {
    List<MemberDto> memberList;
}
