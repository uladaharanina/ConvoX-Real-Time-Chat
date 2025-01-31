import { ReactElement } from "react";
'use client'



export const Header = ():ReactElement => {

    return(
        
            <header className="bg-[var(--primary)] text-[var(--white)] shadow-lg py-4">
              <div className="flex justify-between items-center  max-w-screen-xl mx-auto">
                {/* Logo Section */}
                <div className="text-3xl font-bold transition-all duration-300 hover:scale-105">
                  <span className="text-secondary">ConvoX</span>
                </div>
        
                {/* Navigation */}
                <nav>
                  <ul className="flex justify-center gap-[3em]">
                    <li>
                      <a
                        href="#"
                        className="hover:border-b-white border-b-[var(--primary)] border-b-2 transition-all duration-300 transform hover:scale-110 px-3">Home</a>
                    </li>
                    <li>
                      <a
                        href="#"
                        className="hover:border-b-white border-b-[var(--primary)] border-b-2 transition-all duration-300 transform hover:scale-110 px-3"
                      >
                        Chat
                      </a>
                    </li>
                    <li>
                      <a
                        href="https://github.com/uladaharanina/ConvoX-Real-Time-Chat"
                        className="hover:border-b-white border-b-[var(--primary)] border-b-2 transition-all duration-300 transform hover:scale-110 px-3"
                      >
                        GitHub
                      </a>
                    </li>
                  </ul>
                </nav>
        
                <div className="ml-6">
                  <button className="button-secondary">Get Started</button>                
                </div>
              </div>
            </header>
          
    )
}