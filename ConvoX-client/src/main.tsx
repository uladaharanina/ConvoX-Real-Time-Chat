import { createRoot 
} from 'react-dom/client'
import './index.css'
import './globals.css'

import { BrowserRouter, Routes, Route } from "react-router";
import { ChatComponent } from './layouts/ChatComponent.tsx';
import { Home } from './layouts/Home.tsx';

createRoot(document.getElementById('root')!).render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/chats" element={<ChatComponent />} />
    </Routes>
  </BrowserRouter>
)
