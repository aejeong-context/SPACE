package so.ego.space.domains.task.domain.damain;

import lombok.*;
import so.ego.space.domains.project.domain.domain.Project;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@Table(name = "task")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Task {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private String title;
    private String content;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus status;

    private LocalDate start_date;
    private LocalDate end_date;

    public void updateTaskTitleContent(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void updateTaskStatus(TaskStatus status) {
        this.status = status;
    }

    public void updateTaskDate(LocalDate start_date, LocalDate end_date) {
        this.start_date = start_date;
        this.end_date = end_date;
    }
}
