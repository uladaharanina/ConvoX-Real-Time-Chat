package ConvoX.ConvoX.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ConvoX.ConvoX.Models.Message;
import ConvoX.ConvoX.Repos.MessageRepo;

@Service
public class MessageService {

    @Autowired
    private final MessageRepo messageRepository;

    public MessageService(MessageRepo messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessages(String receiverId) {
        try {
            List<Message> messages = messageRepository.findByReceiverId(receiverId);
            return messages;
        } catch (Exception e) {
            System.out.println("Error fetching messages: " + e.getMessage());
            return null;
        }

    }

    public Message saveMessage(Message message) {

        try {
            messageRepository.insert(message);
            messageRepository.save(message);
            return message;
        } catch (Exception e) {
            System.out.println("Error saving message: " + e.getMessage());
            return null;
        }
    }
}
