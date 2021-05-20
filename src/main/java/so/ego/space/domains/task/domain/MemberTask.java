package so.ego.space.domains.task.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import so.ego.space.domains.project.domain.Member;

import javax.persistence.*;

@Entity
@Getter
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
