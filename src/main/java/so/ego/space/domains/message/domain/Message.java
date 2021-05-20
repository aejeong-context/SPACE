package so.ego.space.domains.message.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import so.ego.space.domains.BaseTimeEntity;
import so.ego.space.domains.project.domain.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "message")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Message extends BaseTimeEntity {

    @Id
    @GeneratedValue()
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "send_id")
    private Member send_member;

    @ManyToOne
    @JoinColumn(name = "read_id")
    private Member read_member;

    private LocalDateTime send_date;
    private LocalDateTime read_date;

}
