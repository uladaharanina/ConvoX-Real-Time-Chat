package ConvoX.Models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Message")
public class Message {

    @Id
    private String _id;
    private String chatId;
    private String senderId;
    private String receiverId;
    private String content;
    private LocalDateTime timestamp;

    // Constructors...

    public String getMessageId() {
        return _id;
    }

    public String getChatId() {
        return chatId;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setMessageId(String message_id) {
        this._id = message_id;
    }

    public void getChatId(String chat_id) {
        this.chatId = chat_id;
    }

    public void setSenderId(String sender_id) {
        this.senderId = sender_id;
    }

    public void setReceiverId(String receiver_id) {
        this.receiverId = receiver_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
