'use client'
import { ReactElement, useState } from "react"
import { IoIosSend } from "react-icons/io";


interface Message{
    chatId:string;
    senderId:string;
    receiverId:string;
    content:string;
    time: Date;
}

interface Properties {
    updateChat: (data:Message) => void
}

export const MessageInput = ({ updateChat }: Properties): ReactElement => {

    const [socket, setSocket] = useState<WebSocket | null>(null);
    const [messageText, setMessageText] = useState<string>("");
    const [message, setMessage] = useState<Message | null>(null);

    const connectToServer = async (): Promise<void> => {

        const socket:WebSocket = new WebSocket("ws://localhost:8080/api/connect");
        
        if(socket !=null){
            socket.onopen = (event: Event) => {
                console.log("WebSocket connection established");
                socket.send("Hello, server!"); // Send a message to the server
                setMessage({
                    chatId: "123",
                    senderId: "user1",
                    receiverId: "user2",
                    content: "Hello, server!",
                    time: new Date()
                });
              };
        }
        
        setSocket(socket);
    }

    const sendMessage = () => {
        if(message == null){
            alert("Please enter a message");
            return;
        }
        const messageToSend: Message = {
            chatId: "123",
            senderId: "user1",
            receiverId: "user2",
            content: messageText,
            time: new Date()
        }
        if(socket!=null){
            socket.send(JSON.stringify(messageToSend));
            updateChat(messageToSend);
        }
    }

    if(socket!=null){
        socket.onmessage = function(event) {
            const response:Message = {
                chatId: "123",
                senderId: "user2",
                receiverId: "user1",
                content: event.data,
                time: new Date()
            }

            updateChat(response);
          };
    }


    return(
        <>

            <div className="">
                {/*
                            <button className="block m-auto mt-3" onClick={connectToServer}>Connect</button>

                */}
 
                <div className="flex">
                    <input type="text" className="primary_input mr-10 ml-5"onChange={(e) => setMessageText(e.target.value)}/>
                    <button className="button-primary flex justify-center items-center gap-[5px]" onClick={sendMessage}>
                        <span>Send</span> 
                        <IoIosSend className="text-[1.5em] "/></button>
                </div>
            </div>
               

        </>
    )
}