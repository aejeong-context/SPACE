package so.ego.space.domains.project.application.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ProjectUpdateRequest {
    private Long id;

    private String name;
    private String content;

    private LocalDate start_date;
    private LocalDate end_date;

    private Long user_id;
}
