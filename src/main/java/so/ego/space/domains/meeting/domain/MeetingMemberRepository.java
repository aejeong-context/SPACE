package so.ego.space.domains.meeting.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MeetingMemberRepository {

    private final EntityManager em;

    public void save(MeetingMember meetingMember){
        em.persist(meetingMember);
    }

    //회의멤버 상세보기
    public MeetingMember meetingMember(Long id){
        return em.find(MeetingMember.class, id);
    }

}
