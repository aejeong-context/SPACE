package so.ego.space.domains.message.domain;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import so.ego.space.domains.project.domain.Member;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {
//    Optional<Message> findByRead_memberOrSend_member(Long member_id);

//    @Query("select m from Message m where m.send_member.id = :member1_id and m.read_member.id = :member2_id or m.send_member.id = :member2_id and m.read_member.id = :member1_id")

    @Query("select m from Message m where m.send_member.id in (:member1_id, :member2_id) and m.read_member.id in (:member1_id, :member2_id)")
    List<Message> findByTalk(Long member1_id, Long member2_id);

    @Query("select m from Message m where m.send_member.id in (:member_id, :otherMemberId) and m.read_member.id in (:member_id, :otherMemberId) and m.content like %:keyword% ")
    List<Message> findByTalkSearch(Long member_id,Long otherMemberId, String keyword);

//    List<Message> findByRead_memberAndRead_date(Member member, LocalDateTime read_date);
    @Query("select m from Message m where m.read_member.id = :member_id and m.read_date is NULL")
    List<Message> findByNewMessage(Long member_id);


//    // member_id1 == member_id3, member_id2 == member_id4
//    Optional<List<Message>> findByRead_memberAndSend_memberOrSend_memberAndRead_member(Long member_id1, Long member_id2);
//
//    // member1이 보내고 member2가 받은 메시지
//    Optional<List<Message>> findBySend_memberAndRead_member(Long member1_id, Long member2_id);
//
//    // member2가 보내고 member1이 받은 메시지
//    Optional<List<Message>> findByRead_memberAndSend_member(Long member1_id, Long member2_id);


}
