import { ReactElement, useEffect, useState } from "react"
import { Header } from "../components/Header"
import '../styles/HomeStyle.css';
import WaveAnimation from "../components/WaveAnumation";
import { FaLinkedin } from "react-icons/fa";
import { FaGithub } from "react-icons/fa";
import Login from "../components/Login";


export const Home = (): ReactElement => {

    const[isAuthenticated, setisAuthenticated] = useState<boolean>();
    const[isLoginModalOpen, setisLoginVisibility] = useState<boolean>();

    const displayLogin = () => {
        setisLoginVisibility(true);
    }

    const closeLogin = () => {
        setisLoginVisibility(false);
    }
    return(
        <>
        <Header displayLogin={displayLogin}></Header>

        <WaveAnimation></WaveAnimation>
        
            <div className={`transition-opacity duration-500 ${isLoginModalOpen ? 'opacity-100' : 'opacity-0 pointer-events-none'}`}>
            <Login onClose={closeLogin} />
          </div>
            
        
        <main className="w-[1300px] m-auto mt-12">
            <h1 className="font-extrabold text-4xl md:text-5xl lg:text-6xl text-gray-900 leading-tight">Welcome to ConvoX</h1>
            <h3 className="font-semibold text-2xl md:text-3xl text-gray-800 leading-snug">Connect, Chat, Create Memories</h3>
        </main>
        <section className="absolute right-20 bottom-20 flex gap-[10px]">
            <a href="https://www.linkedin.com/in/uladaharanina/"><FaLinkedin className="text-[2.4em] hover:scale-125 transition duration-300 ease-in-out text-[var(--primary-darker)]"/></a>
            <a href="https://github.com/uladaharanina"><FaGithub className="text-[2.4em] hover:scale-125 transition duration-300 ease-in-out text-[var(--primary-darker)]"/></a>
        </section>
        </>
    )
}
