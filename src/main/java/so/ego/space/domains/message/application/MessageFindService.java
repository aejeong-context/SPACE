package so.ego.space.domains.message.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.message.application.dto.MessageFindRequest;
import so.ego.space.domains.message.application.dto.MessageDto;
import so.ego.space.domains.message.application.dto.MessageFindResponse;
import so.ego.space.domains.message.application.dto.MessageSearchRequest;
import so.ego.space.domains.message.domain.Message;
import so.ego.space.domains.message.domain.MessageRepository;
import so.ego.space.domains.project.domain.Member;
import so.ego.space.domains.project.domain.MemberRepository;
import so.ego.space.domains.user.domain.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MessageFindService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    // 메시지 검색
    public MessageFindResponse findTalkSearch(MessageSearchRequest messageSearchRequest){
        List<Message> messageList = messageRepository.findByTalkSearch(
                messageSearchRequest.getMember_id(), messageSearchRequest.getKeyword()
        );
        List<MessageDto> messageDtoList = new ArrayList<>();
        for (Message m: messageList) {
            messageDtoList.add(MessageDto.builder()
                    .id(m.getId())
                    .content(m.getContent())
                    .send_member(m.getSend_member().getId())
                    .send_member_image(m.getSend_member().getUser().getProfile().getPath())
                    .read_member(m.getRead_member().getId())
                    .read_member_image(m.getRead_member().getUser().getProfile().getPath())
                    .read_date(m.getRead_date())
                    .send_date(m.getSend_date())
                    .build());
        }
        return MessageFindResponse.builder()
                .messageList(messageDtoList)
                .build();
    }
    // 안 읽은 메시지 가져오기
    public MessageFindResponse findNewMessage(Long member_id){
        List<Message> messageList = messageRepository.findByNewMessage(member_id);
        List<MessageDto> messageDtoList = new ArrayList<>();
        for (Message m : messageList) {
            messageDtoList.add(MessageDto.builder()
                    .id(m.getId())
                    .send_member(m.getSend_member().getId())
                    .read_member(m.getRead_member().getId())
                    .send_date(m.getSend_date())
                    .content(m.getContent())
                    .build());
        }
        return MessageFindResponse.builder()
                .messageList(messageDtoList).build();
    }

    // 대화내용 가져오기
    @Transactional
    public MessageFindResponse findTalk(MessageFindRequest messageFindRequest){
        List<Message> messageList = messageRepository.findByTalk(
                messageFindRequest.getMember1_id(),
                messageFindRequest.getMember2_id()
        );
//                .orElseThrow(() -> new IllegalArgumentException("invalid member_id."));

        List<MessageDto> messageDtoList = new ArrayList<>();
        for (Message m : messageList) {
            // 읽은 시간이 없다면 읽은 시간 추가
            if(m.getRead_date()==null){
                m.updateReadDate(LocalDateTime.now());
            }

            messageDtoList.add(MessageDto.builder()
                    .id(m.getId())
                    .content(m.getContent())
                    .read_date(m.getRead_date())
                    .send_date(m.getSend_date())
                    .read_member(m.getRead_member().getId())
                    .send_member(m.getSend_member().getId())
                    .read_member_image(m.getRead_member().getUser().getProfile().getPath())
                    .send_member_image(m.getSend_member().getUser().getProfile().getPath())
                    .build());
        }
        return MessageFindResponse.builder()
                .messageList(messageDtoList)
                .build();
    }
}
