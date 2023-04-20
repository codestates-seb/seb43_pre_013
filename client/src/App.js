// import React from "react";
// import { Counter } from "./features/counter/Counter";
//컴포넌트
import NavigationBar from "./components/NavigationBar";
import Answer from "./components/Answer";
import Askquestion from "./components/askQuestion";
//페이지
import MainPage from "./pages/MainPage";
import Login from "./pages/Login";
import UserInfo from "./pages/UserInfo";

import { Route, Routes } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <NavigationBar />
      <Routes>
        <Route path="/" element={<MainPage />}></Route>
        <Route path="/login" element={<Login />}></Route>
        <Route path="/userinfo" element={<UserInfo />}></Route>
        <Route path="/question" element={<Answer />}></Route>
        <Route path="/askquestion" element={<Askquestion />}></Route>
      </Routes>
    </div>
  );
}
export default App;
