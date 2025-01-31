import { ReactElement, useEffect, useState } from "react"
import { Header } from "../components/Header"
import '../styles/HomeStyle.css';
import WaveAnimation from "../components/WaveAnumation";


export const Home = (): ReactElement => {



    return(
        <>
        <Header></Header>

        <WaveAnimation></WaveAnimation>
        <main className="w-[1300px] m-auto mt-12">
            <h1 className="font-extrabold text-4xl md:text-5xl lg:text-6xl text-gray-900 leading-tight">Welcome to ConvoX</h1>
            <h3 className="font-semibold text-2xl md:text-3xl text-gray-800 leading-snug">Connect, Chat, Create Memories</h3>
        </main>
        </>
    )
}