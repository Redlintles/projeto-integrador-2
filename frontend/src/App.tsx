import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import Home from "./pages/Home/Home";
import Register from "./pages/Register/Register";
import Login from "./pages/Login/Login";
import Initial from "./pages/Initial/Initial";
import Suggestion from "./pages/Suggestion/Suggestion";
import Ranking from "./pages/Ranking/Ranking";
import { userContext, UserContextProvider } from "./contexts/UserContext";
import { useContext, useEffect } from "react";
import Cookies from "js-cookie";
import { ApiResponse } from "./types/ApiResponse";
import { User } from "./types/User";
function App() {
  const { user, setUser } = useContext(userContext);

  useEffect(() => {
    const cookie = Cookies.get("user");

    if (cookie && user.user === null) {
      fetch(`/api/token/userByToken/${cookie}`)
        .then((res) => {
          return res.json();
        })
        .then((data: ApiResponse) => {
          if (data.data) {
            const newUser: User = data.data as User;
            setUser({
              user: newUser,
              token: cookie,
            });
          }
        });
    }
  }, []);

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
