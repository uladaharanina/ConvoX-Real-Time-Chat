package ConvoX.ConvoX.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ConvoX.ConvoX.Models.Message;
import ConvoX.ConvoX.Services.MessageService;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
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



}
