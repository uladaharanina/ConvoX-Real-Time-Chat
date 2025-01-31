'use client'
import TextField from "@mui/material/TextField/TextField"
import { ReactElement, useState } from "react"

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

export const Chat = ({ updateChat }: Properties): ReactElement => {

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

            <div className="text-white">
            <TextField id="standard-basic" label="Username" variant="standard"  className="text-gray-700"/>
            <button className="block m-auto mt-3" onClick={connectToServer}>Connect</button>
 
                <div>
                    <TextField id="standard-basic" label="Type your message..." variant="standard" className="text-gray-700" onChange={(e) => setMessageText(e.target.value)}/>                
                    <button className="block m-auto mt-3" onClick={sendMessage}>Send</button>
                </div>
            </div>
               

        </>
    )
}