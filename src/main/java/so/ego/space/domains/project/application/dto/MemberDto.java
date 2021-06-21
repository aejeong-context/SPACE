package so.ego.space.domains.project.application.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.project.domain.MemberLevel;
import so.ego.space.domains.project.domain.Project;
import so.ego.space.domains.user.domain.Profile;
import so.ego.space.domains.user.domain.User;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
public class MemberDto {
    private Long userId;

    private Long memberId;

    private String profilePath;

    private String nickname;

    private String position;

    private MemberLevel level;
}
