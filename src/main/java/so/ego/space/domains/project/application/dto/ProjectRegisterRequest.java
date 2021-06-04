package so.ego.space.domains.project.application.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ProjectRegisterRequest {
    private Long user_id;

    private String name;
    private String content;

    private String start_date;
    private String end_date;
}
