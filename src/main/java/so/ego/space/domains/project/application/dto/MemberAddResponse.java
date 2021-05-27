package so.ego.space.domains.project.application.dto;

import lombok.*;
import so.ego.space.domains.project.domain.MemberLevel;
import so.ego.space.domains.user.domain.Profile;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberAddResponse {

    private Long project_id;

    private String email;

    private MemberLevel level;
}
