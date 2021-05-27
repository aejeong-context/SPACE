package so.ego.space.domains.message.application.dto;

import lombok.*;
import so.ego.space.domains.project.domain.Member;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MessageDto {
    private Long id;

    private String content;

    private Long send_member;
    private Long read_member;

    private LocalDateTime send_date;
    private LocalDateTime read_date;
}
