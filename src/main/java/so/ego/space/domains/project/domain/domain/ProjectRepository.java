package so.ego.space.domains.project.domain.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProjectRepository extends JpaRepository<Project, Long> {

}
