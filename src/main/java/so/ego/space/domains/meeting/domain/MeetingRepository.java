package so.ego.space.domains.meeting.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MeetingRepository {

    private final EntityManager em;

    //회의 등록
    public void save(Meeting meeting){
        em.persist(meeting);
    }

    //회의 목록
    public List<Meeting> meetingList(){
        return em.createQuery("select m from Meeting m", Meeting.class).getResultList();
    }

    //회의 상세보기
    public Meeting meeting(Long id){
        return em.find(Meeting.class, id);
    }
}
