import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import Home from "./pages/Home/Home";
import Register from "./pages/Register/Register";
import Login from "./pages/Login/Login";
import Initial from "./pages/Initial/Initial";
import Suggestion from "./pages/Suggestion/Suggestion";
import Ranking from "./pages/Ranking/Ranking";
import { UserContextProvider } from "./contexts/UserContext";

function App() {
  return (
    <>
      <UserContextProvider>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Home />}></Route>
            <Route path="/register" element={<Register />}></Route>
            <Route path="/login" element={<Login />}></Route>
            <Route path="/initial" element={<Initial />}></Route>
            <Route path="/suggestion" element={<Suggestion />}></Route>
            <Route path="/ranking" element={<Ranking />}></Route>
          </Routes>
        </BrowserRouter>
      </UserContextProvider>
    </>
  );
}

export default App;
