package so.ego.space.domains.user.domain;

import lombok.*;

import javax.persistence.*;
import so.ego.space.domains.BaseTimeEntity;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public void updateNickname(String nickname){
        this.nickname = nickname;
    }
    public void updatePassword(String password){
        this.password = password;
    }
    public void updateProfilePath(String path){
        this.profile.updateProfilePath(path);
    }

}
