import { useState } from 'react'
import { MessageInput } from './components/MessageInput'
import './App.css'
import { ChatHistory } from './components/ChatHistory'
import { Header } from './components/Header'


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Header></Header>
      <ChatHistory></ChatHistory>
     </>
  )
}

export default App
