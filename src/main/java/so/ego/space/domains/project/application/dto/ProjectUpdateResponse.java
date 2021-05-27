package so.ego.space.domains.project.application.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectUpdateResponse {
    private String name;
    private String content;

    private LocalDate start_date;
    private LocalDate end_date;

}
