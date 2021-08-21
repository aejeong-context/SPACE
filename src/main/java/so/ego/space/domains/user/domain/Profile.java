package so.ego.space.domains.user.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "profile")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Profile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;

    @Builder
    public Profile(String path) {
        this.path = path;
    }

    public void updateProfilePath(String path){this.path = path;}
}
