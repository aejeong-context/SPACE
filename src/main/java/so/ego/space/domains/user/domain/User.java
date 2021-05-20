package so.ego.space.domains.user.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String password;
    private String nickname;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Builder
    public User(String email, String password, String nickname, Profile profile) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profile = profile;
    }
}
