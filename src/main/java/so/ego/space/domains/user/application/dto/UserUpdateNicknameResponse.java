package so.ego.space.domains.user.application.dto;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserUpdateNicknameResponse {
    private Long id;
    private String new_nickname;
}
