package so.ego.space.domains.task.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskRepository {

    private final EntityManager em;

    public void save(Task task){
        em.persist(task);
    }

    //업무 목록
    public List<Task> taskList(){
        return em.createQuery("select t from Task t", Task.class).getResultList();
    }

    //업무 상세보기
    public Task task(Long id){
        return em.find(Task.class, id);
    }



}
