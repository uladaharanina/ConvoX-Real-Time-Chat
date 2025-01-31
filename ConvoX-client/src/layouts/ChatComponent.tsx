import { ReactElement } from "react";
import { ChatHistory } from "../components/ChatHistory";
import { Header } from "../components/Header";

export const ChatComponent = ():ReactElement => {
    return(
        <>
             <Header></Header>
             <ChatHistory></ChatHistory>

        </>
    )
}