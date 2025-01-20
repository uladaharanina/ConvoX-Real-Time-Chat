package ConvoX.ConvoX.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
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

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/getMessages/{receiver_id}")
    public ResponseEntity<List<Message>> getMessage(@PathVariable("receiver_id") String receiver_id) {

        try {
            List<Message> userMessages = messageService.getMessages(receiver_id);
            return ResponseEntity.ok(userMessages);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

    // This will be through websocket
    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody Message message) {

        Message result = messageService.saveMessage(message);
        if (result != null) {
            return "Message sent successfully!";
        }
        return "Message failed";
    }
}
