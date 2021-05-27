package so.ego.space.domains.message.application.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MessageFindResponse {
    private List<MessageDto> messageList;
}
