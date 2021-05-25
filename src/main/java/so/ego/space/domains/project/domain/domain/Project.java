package so.ego.space.domains.project.domain.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "project")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String content;

    private LocalDate start_date;
    private LocalDate end_date;


    @OneToMany(mappedBy = "project")
    @JsonBackReference
    private List<Member> memberList = new ArrayList<>();

    @Builder
    public Project(String name, String content, LocalDate start_date, LocalDate end_date, String leader) {
        this.name = name;
        this.content = content;
        this.start_date = start_date;
        this.end_date = end_date;
    }

}
