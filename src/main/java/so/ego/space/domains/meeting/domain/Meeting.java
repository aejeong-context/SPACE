package so.ego.space.domains.meeting.domain;

import lombok.*;
import so.ego.space.domains.BaseTimeEntity;
import so.ego.space.domains.project.domain.Project;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table(name = "meeting")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Meeting extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private String name;
    private String goal;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private MeetingCheckType check;

    private LocalDateTime start_time;
    private LocalDateTime end_time;

    public void updateMeetingStatus(MeetingCheckType check) {
        this.check = check;
    }

    public void updateMeeting(String name, String goal, LocalDateTime start_time, LocalDateTime end_time) {
        this.name = name;
        this.goal = goal;
        this.start_time = start_time;
        this.end_time = end_time;
    }
}
