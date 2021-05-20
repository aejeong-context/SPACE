package so.ego.space.domains.meeting.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import so.ego.space.domains.project.domain.Member;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "meeting_member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MeetingMember {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

}
