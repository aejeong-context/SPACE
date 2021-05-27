package so.ego.space.domains.user.application.dto;

import lombok.Getter;

@Getter
public class UserDropRequest {
    private Long id;
    private String email;
    private String password;
    private String nickname;
}
