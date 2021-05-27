package so.ego.space.domains.message.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import so.ego.space.domains.message.application.MessageFindService;
import so.ego.space.domains.message.application.dto.*;

@RequiredArgsConstructor
@RestController
public class MessageFindController {
    private final MessageFindService messageFindService;

    @PostMapping("/messages")
    public MessageFindResponse findTalk(@RequestBody MessageFindRequest messageFindRequest){
        return messageFindService.findTalk(messageFindRequest);
    }

    @GetMapping("/message/{member_id}")
    public MessageFindResponse findNewMessage(@PathVariable Long member_id){
        return messageFindService.findNewMessage(member_id);
    };

    @PostMapping("/message/search")
    public MessageFindResponse findTalkSearch(@RequestBody MessageSearchRequest messageSearchRequest){
        return messageFindService.findTalkSearch(messageSearchRequest);
    }
}
