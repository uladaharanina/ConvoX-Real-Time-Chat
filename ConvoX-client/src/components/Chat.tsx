'use client'
import TextField from "@mui/material/TextField/TextField"
import { ReactElement, useState } from "react"

export const Chat = () :ReactElement => {

    const [socket, setSocket] = useState<WebSocket | null>(null);
    const [message, setMessage] = useState("");

    const connectToServer = (): void => {
        setSocket(new WebSocket("ws://localhost:8080/api/connect"));
        if(socket !=null){
            socket.onopen = (event: Event) => {
                console.log("WebSocket connection established");
                socket.send("Hello, server!"); // Send a message to the server
              };
        }
        else{
            console.log("WebSocket connection failed");
        }
   
    }

    const sendMessage = () => {
        if(socket!=null){
            socket.send(message);
        }
    }

    if(socket!=null){
        socket.onmessage = function(event) {
            console.log('Message from server:', event.data);
          };
    }



    return(
        <>

            <div className="text-white">
            <TextField id="standard-basic" label="Username" variant="standard"  className="text-gray-700"/>
            <button className="block m-auto mt-3" onClick={connectToServer}>Connect</button>
 
                <div>
                    <TextField id="standard-basic" label="Type your message..." variant="standard" className="text-gray-700" onChange={(e) => setMessage(e.target.value)}/>                
                    <button className="block m-auto mt-3" onClick={sendMessage}>Send</button>
                </div>
            </div>
               

        </>
    )
}