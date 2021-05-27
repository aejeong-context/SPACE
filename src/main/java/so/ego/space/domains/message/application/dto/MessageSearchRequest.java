package so.ego.space.domains.message.application.dto;

import lombok.Getter;

@Getter
public class MessageSearchRequest {
    private Long member_id;
    private String keyword;
}
