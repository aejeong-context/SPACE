package so.ego.space.domains.project.application.dto;

import lombok.Getter;

@Getter
public class MemberAddRequest {
    private Long project_id;
    private String member_email;
}
