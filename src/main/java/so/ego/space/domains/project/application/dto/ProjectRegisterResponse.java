package so.ego.space.domains.project.application.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectRegisterResponse {
    private Long user_id;

    private Long id;

    private String name;
    private String content;

    private LocalDate start_date;
    private LocalDate end_date;
}
