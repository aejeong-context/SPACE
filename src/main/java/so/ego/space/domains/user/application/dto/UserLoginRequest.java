package so.ego.space.domains.user.application.dto;

import lombok.Getter;

@Getter
public class UserLoginRequest {
    private String email;
    private String password;

}
