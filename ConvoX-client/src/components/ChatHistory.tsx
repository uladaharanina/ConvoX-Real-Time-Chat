import { ReactElement, useState } from "react";
import { MessageInput } from "./MessageInput";
import { UserList } from './UserList';

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
            <section className="w-[600px] mx-auto mt-12 p-5 bg-[var(--bg-white)] rounded-xl shadow-lg">
                <h1 className="text-center border-b-[var(--bg-primary)] border-b-3 p-4 rounded-sm">Chats</h1>
            <ul className="rounded-sm bg-slay-200 p-5">
                {
                chatMessages.length > 0 &&
                chatMessages.map((message, index) => (
                    <li key={index}>{message.content}</li>
                ))}
                <li className="text-center">No chat history found!</li>
            </ul>

            <div>
                <MessageInput updateChat = {updateChat}></MessageInput>
            </div>

            </section>
           
        </>
    )

}
