package so.ego.space.domains.meeting.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MeetingTaskRepository {

    private final EntityManager em;

    public void save(MeetingTask meetingTask){
        em.persist(meetingTask);
    }

    //회의멤버 상세보기
    public MeetingTask meetingTask(Long id){
        return em.find(MeetingTask.class, id);
    }

}
