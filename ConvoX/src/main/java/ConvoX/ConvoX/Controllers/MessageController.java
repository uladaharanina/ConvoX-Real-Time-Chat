package ConvoX.ConvoX.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/getMessages")
    public String getMessage() {
        return "Hello, ConvoX! This is your personal, AI-powered conversational assistant.";
    }

    @PostMapping("/sentMessage")
    public String sendMessage(@RequestBody Message message) {

        Message result = messageService.saveMessage(message);
        if (result != null) {
            return "Message sent successfully!";
        }
        return "Message failed";
    }
}
