package so.ego.space.domains.project.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

//    @Query(value = "select * from projects p inner join member m on p.id = m.project_id inner join user u on m.user_id = u.id where user_id = :user_id",nativeQuery = true)
    @Query("select  p from Project p inner join Member m on p.id = m.project.id where m.user.id = :user_id")
    List<Project> findMyProject(Long user_id);

//    @Query(value = "SELECT COUNT(*) FROM projects p INNER JOIN task T ON p.id = T.project_id WHERE p.id = :project_id", nativeQuery = true)
    @Query("select count(t) from Project p inner join Task t on p.id = t.id where p.id = :project_id")
    Long countByTaskAll(Long project_id);

//    @Query(value = "SELECT COUNT(*) FROM projects p INNER JOIN task T ON p.id = T.project_id WHERE p.id = :project_id AND T.status = 'DONE'", nativeQuery = true)
    @Query("select count(p) from Project p inner join Task t on p.id = t.project.id where p.id = :project_id and t.status = 'DONE'")
    Long countByTaskDone(Long project_id);

}
