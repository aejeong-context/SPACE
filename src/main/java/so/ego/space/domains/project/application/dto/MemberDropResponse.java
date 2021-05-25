package so.ego.space.domains.project.application.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDropResponse {
    private Long project_id;
    private String nickname;
}
