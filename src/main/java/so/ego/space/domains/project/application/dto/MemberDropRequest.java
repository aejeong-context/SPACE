package so.ego.space.domains.project.application.dto;

import lombok.Getter;

@Getter
public class MemberDropRequest {
    private Long project_id;
    private String nickname;
}
