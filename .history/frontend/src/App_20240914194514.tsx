import { useEffect, useState } from "react";

import "./App.css";

function App() {
  const [data, setData] = useState("");

  useEffect(() => {
    const url = import.meta.env.VITE_API_URL + "/hello";
    fetch(import.meta.env.VITE_API_URL + "/hello")
      .then((res) => {
        console.log(res);
        return res.text();
      })
      .then((res) => {
        console.log(res);
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
