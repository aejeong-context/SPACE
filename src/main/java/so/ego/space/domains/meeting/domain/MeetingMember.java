package so.ego.space.domains.meeting.domain;

import lombok.*;
import so.ego.space.domains.project.domain.Member;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name = "meeting_member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MeetingMember {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

}
