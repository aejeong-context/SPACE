package so.ego.space.domains.message.domain;

import lombok.*;
import so.ego.space.domains.BaseTimeEntity;
import so.ego.space.domains.project.domain.domain.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "message")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Message extends BaseTimeEntity {

    @Id
    @GeneratedValue
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

    @Builder
    public Message(String content, Member send_member, Member read_member, LocalDateTime send_date, LocalDateTime read_date) {
        this.content = content;
        this.send_member = send_member;
        this.read_member = read_member;
        this.send_date = send_date;
        this.read_date = read_date;
    }

    public void updateReadDate(LocalDateTime read_date){
        this.read_date = read_date;
    }
}
