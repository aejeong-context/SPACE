package so.ego.space.domains.project.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ProjectDetailDto {
    private Long id;

    private String name;
    private String content;

    private LocalDate start_date;
    private LocalDate end_date;

    private Long all_count;
    private Long done_count;

    private List<MemberDto> member;

}
