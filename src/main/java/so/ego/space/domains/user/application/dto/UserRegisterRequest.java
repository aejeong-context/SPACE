package so.ego.space.domains.user.application.dto;

import lombok.Getter;

@Getter
public class UserRegisterRequest {
    private String email;
    private String password;
    private String nickname;

}
