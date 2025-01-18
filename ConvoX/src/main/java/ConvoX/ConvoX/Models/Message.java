package ConvoX.ConvoX.Models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Message")
public class Message {

    @Id
    private String message_id;
    private String sender_id;
    private String receiver_id;
    private String content;
    private LocalDateTime timestamp;

    // Constructors...

    // Getters and setters...
    public Message(String message_id, String sender_id, String receiver_id, String content, LocalDateTime timestamp) {

        this.message_id = message_id;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getMessageId() {
        return message_id;
    }

    public String getSenderId() {
        return sender_id;
    }

    public String getReceiverId() {
        return receiver_id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setMessageId(String message_id) {
        this.message_id = message_id;
    }

    public void setSenderId(String sender_id) {
        this.sender_id = sender_id;
    }

    public void setReceiverId(String receiver_id) {
        this.receiver_id = receiver_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
