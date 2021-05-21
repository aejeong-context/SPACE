package so.ego.space.domains.user.application.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserCheckEmailResponse {
    private String email;
    private Boolean accept;
}
