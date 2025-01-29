import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import { Chat } from './components/Chat'
import './App.css'
import './globals.css'
import { ChatHistory } from './components/ChatHistory'


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <ChatHistory></ChatHistory>
     </>
  )
}

export default App
