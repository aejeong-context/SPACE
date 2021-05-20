package so.ego.space.domains.task.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import so.ego.space.domains.project.domain.Project;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "task")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Task {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private String content;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus status;

    private LocalDate start_date;
    private LocalDate end_date;

}
