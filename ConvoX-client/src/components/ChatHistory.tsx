import { ReactElement, useState } from "react";
import { Chat } from "./Chat";

interface Message{
    chatId:string,
    senderId:string,
    receiverId:string,
    content:string,
    time: Date
}

export const ChatHistory = (): ReactElement => {

    const [chatMessages, setChatMessages] = useState<Message[]>([]);

    const updateChat = (data:Message) :void => {
        setChatMessages(chatMessages => [...chatMessages, data])
    }

    return(
        <>
            <ul className="rounded-sm bg-slay-200 p-5">
                {
                chatMessages.length > 0 &&
                chatMessages.map((message, index) => (
                    <li key={index}>{message.content}</li>
                ))}
                <li>No chat history found!</li>
            </ul>

            <Chat updateChat = {updateChat}></Chat>
        </>
    )

}
