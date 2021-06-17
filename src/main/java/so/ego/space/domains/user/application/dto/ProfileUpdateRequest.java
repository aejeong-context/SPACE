package so.ego.space.domains.user.application.dto;

import lombok.Getter;

@Getter
public class ProfileUpdateRequest {
    private Long userId;
    private String path;
}
