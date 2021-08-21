package so.ego.space.domains.meeting.domain;

import lombok.*;
import so.ego.space.domains.task.damain.Task;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name = "meeting_task")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MeetingTask {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Enumerated(value = EnumType.STRING)
    private MeetingTaskType type;

}
