package so.ego.space.domains.project.application.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberUpdatePositionResponse {
    private String nickname;
    private String position;
}
