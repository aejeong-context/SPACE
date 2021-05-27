package so.ego.space.domains.message.application.dto;

import lombok.Getter;

@Getter
public class MessageAddRequest {
    private String content;

    private Long send_member;
    private Long read_member;
}
