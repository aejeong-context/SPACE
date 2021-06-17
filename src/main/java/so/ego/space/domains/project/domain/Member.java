package so.ego.space.domains.project.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;
import so.ego.space.domains.user.domain.User;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "user_id")
    private User user;


    private String position;

    @Enumerated(value = EnumType.STRING)
    private MemberLevel level;

    @Builder
    public Member(Project project, User user, MemberLevel level) {
        this.project = project;
        this.user = user;
        this.level = level;
    }

    public void updatePosition(String position){
        this.position = position;
    }
}
