package so.ego.space.domains.user.application.dto;

import lombok.Getter;

@Getter
public class UserUpdateNicknameRequest {
    private Long id;
    private String nickname;
}
