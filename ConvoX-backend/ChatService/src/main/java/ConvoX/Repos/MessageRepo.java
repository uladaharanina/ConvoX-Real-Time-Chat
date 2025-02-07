package ConvoX.Repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ConvoX.Models.Message;

public interface MessageRepo extends MongoRepository<Message, String> {

    List<Message> findByReceiverId(String receiverId);

}
