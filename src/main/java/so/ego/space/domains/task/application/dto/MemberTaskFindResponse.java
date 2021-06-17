package so.ego.space.domains.task.application.dto;

import lombok.Builder;
import lombok.Getter;
import so.ego.space.domains.project.domain.MemberLevel;
import so.ego.space.domains.user.domain.Profile;

@Getter
@Builder
public class MemberTaskFindResponse {

    private Long memberTaskId;
    private Long taskId;
    private Long memberId;
    private MemberLevel level;
    private String profilePath;
    private String nickname;
}
