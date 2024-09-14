import { useEffect, useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";

function App() {
  const [count, setCount] = useState(0);

  const [data, setData] = useState("");

  useEffect(() => {
    fetch(import.meta.env.VITE_API_URL)
      .then((res) => {
        return res.text();
      })
      .then((res) => {
        setData(res);
      });
  }, []);

  return (
    <>
      <h1>{data ? data : "It's not working"}</h1>
    </>
  );
}

export default App;
