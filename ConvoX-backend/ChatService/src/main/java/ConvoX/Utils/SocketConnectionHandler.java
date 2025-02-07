package ConvoX.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SocketConnectionHandler extends TextWebSocketHandler {

    List<WebSocketSession> webSocketSessions = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        super.afterConnectionEstablished(session);
        // Logging the connection ID with Connected Message
        System.out.println("Connected");
        // Adding the session into the list
        webSocketSessions.add(session);
    }

    // When client disconnect from WebSocket then this
    // method is called
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        System.out.println(session.getId() + " DisConnected");

        // Removing the connection info from the list
        webSocketSessions.remove(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String[] messages = { "Hello! How can I help you today?",
                "Good morning! How's your day going?",
                "What brings you here today?",
                "Can you tell me more about that?",
                "I'm here if you need assistance!",
                "Is there something specific you'd like to discuss?",
                "Thanks for reaching out to us.",
                "How are you doing today?",
                "Feel free to ask any questions!",
                "I’m happy to help you with that.",
                "Let me know if you need anything else.",
                "Can you clarify what you mean by that?",
                "I'm glad to hear that!",
                "Sorry, could you repeat that?",
                "I think I understand, let me check on that for you.",
                "I can help you with that. Please give me a moment.",
                "That sounds interesting! Tell me more.",
                "I'm here to help, just let me know.",
                "Would you like assistance with that?",
                "Please provide more details so I can help you better.",
                "Sure! I’ll take care of that for you.",
                "Thanks for your patience.",
                "I’ll look into it right away.",
                "How would you like to proceed?",
                "Please let me know if you have any questions.",
                "I’m not sure about that. Let me check.",
                "Can you help me understand this better?",
                "Is there anything else you'd like to know?",
                "Feel free to ask me anything anytime!",
                "I’m happy to help you with any other concerns." };

        String receivedMessage = (String) message.getPayload();
        System.out.println(receivedMessage);
        Random selectRandom = new Random();
        int index = selectRandom.nextInt(0, 29);
        TextMessage replyMessage = new TextMessage(messages[index]);
        session.sendMessage(replyMessage); // Send the message to the recipient
    }

}