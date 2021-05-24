package so.ego.space.domains.project.application.dto;

import lombok.*;
import so.ego.space.domains.project.domain.Project;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectFindResponse {
    Project project;
}
