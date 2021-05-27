package so.ego.space.domains.task.domain.damain;

import lombok.*;
import so.ego.space.domains.project.domain.domain.Member;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name = "member_task")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberTask {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
