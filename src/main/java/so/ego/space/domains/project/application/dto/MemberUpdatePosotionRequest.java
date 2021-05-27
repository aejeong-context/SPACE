package so.ego.space.domains.project.application.dto;

import lombok.Getter;

@Getter
public class MemberUpdatePosotionRequest {
    private Long project_id;
    private String nickname;
    private String position;
}
