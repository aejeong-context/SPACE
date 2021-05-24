package so.ego.space.domains.project.application.dto;

import lombok.*;
import so.ego.space.domains.project.domain.Project;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectFindAllResponse {
    // 프로젝트 리스트
    List<Project> projects;
}
