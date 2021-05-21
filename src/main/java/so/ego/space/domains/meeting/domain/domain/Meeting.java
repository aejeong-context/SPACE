package so.ego.space.domains.meeting.domain.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table(name = "meeting")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Meeting {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String goal;


    @Enumerated(EnumType.STRING)
    private MeetingCheckType check;

    private LocalDateTime start_time;
    private LocalDateTime end_time;

    public void updateMeeting(String goal, MeetingCheckType check) {
        this.goal = goal;
        this.check = check;
    }

}
