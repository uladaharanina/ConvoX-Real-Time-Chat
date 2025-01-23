package ConvoX.ConvoX.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ConvoX.ConvoX.Models.Message;
import ConvoX.ConvoX.Services.MessageService;

@RestController
public class MessageController {

    private final MessageService messageService;
    private final SimpMessagingTemplate messagingTemplate;

    public MessageController(MessageService messageService, SimpMessagingTemplate messagingTemplate) {
        this.messageService = messageService;
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping("api/getMessages/{receiverId}")
    public ResponseEntity<List<Message>> getMessage(@PathVariable("receiverId") String receiverId) {

        try {
            List<Message> userMessages = messageService.getMessages(receiverId);
            return ResponseEntity.ok(userMessages);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

    // This will be through websocket
    // @MessageMapping("/api/conversations/sendMessage/{conversationId}")
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String sendMessage(@DestinationVariable String conversationId, @RequestBody Message message) {

        return "Hello Vlada";

        /*
         * messageService.saveMessage(message);
         * messagingTemplate.convertAndSend("/topic/conversations/" + conversationId,
         * message);
         */

    }

}
