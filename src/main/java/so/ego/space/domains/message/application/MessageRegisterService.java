package so.ego.space.domains.message.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.message.application.dto.MessageAddRequest;
import so.ego.space.domains.message.application.dto.MessageAddResponse;
import so.ego.space.domains.message.domain.Message;
import so.ego.space.domains.message.domain.MessageRepository;
import so.ego.space.domains.project.domain.Member;
import so.ego.space.domains.project.domain.MemberRepository;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MessageRegisterService {
    private final MessageRepository messageRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public MessageAddResponse sendMessage(MessageAddRequest messageAddRequest){
        Member read_member = memberRepository.findById(messageAddRequest.getRead_member())
                .orElseThrow(() -> new IllegalArgumentException("invalid read_member."));
        Member send_member = memberRepository.findById(messageAddRequest.getSend_member())
                .orElseThrow(() -> new IllegalArgumentException("invalid send_member."));
        LocalDateTime send_date = LocalDateTime.now();
        messageRepository.save(Message.builder()
                .content(messageAddRequest.getContent())
                .read_member(read_member)
                .send_member(send_member)
                .send_date(send_date)
                .build());
        return MessageAddResponse.builder()
                .content(messageAddRequest.getContent())
                .read_member(messageAddRequest.getRead_member())
                .send_member(messageAddRequest.getSend_member())
                .send_date(send_date)
                .build();
    }

    public void deleteMessage(Long message_id) {
        messageRepository.delete(messageRepository.findById(message_id)
        .orElseThrow(() -> new IllegalArgumentException("invalid message_id.")));
    }
}
