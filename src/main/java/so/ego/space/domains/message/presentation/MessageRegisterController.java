package so.ego.space.domains.message.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import so.ego.space.domains.message.application.MessageRegisterService;
import so.ego.space.domains.message.application.dto.MessageAddRequest;
import so.ego.space.domains.message.application.dto.MessageAddResponse;

@RequiredArgsConstructor
@RestController
public class MessageRegisterController {
    private final MessageRegisterService messageRegisterService;

    @PostMapping("/message")
    public MessageAddResponse sendMessage(@RequestBody MessageAddRequest messageAddRequest){
        return messageRegisterService.sendMessage(messageAddRequest);
    }

    @DeleteMapping("/message/{message_id}")
    public void deleteMessage(@PathVariable Long message_id){
        messageRegisterService.deleteMessage(message_id);
    }
}
