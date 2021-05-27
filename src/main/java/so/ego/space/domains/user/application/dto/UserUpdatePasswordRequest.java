package so.ego.space.domains.user.application.dto;

import lombok.Getter;

@Getter
public class UserUpdatePasswordRequest {
    private Long id;
    private String email;
    private String old_password;
    private String new_password;
}
