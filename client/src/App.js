// import React from "react";
import Answer from "./components/Answer";
// import { Counter } from "./features/counter/Counter";
//컴포넌트
import NavigationBar from "./components/NavigationBar";
//페이지
import MainPage from "./pages/MainPage";
import Login from "./pages/Login";
import UserInfo from "./pages/UserInfo";

import { Route, Routes } from "react-router-dom";
import styled from "styled-components";

function App() {
  return (
    <div className="App">
      <NavigationBar />
      <ContentWrapper>
        {/* <Counter /> */}
        <Routes>
          <Route path="/" element={<MainPage />}></Route>
          <Route path="/login" element={<Login />}></Route>
          <Route path="/userinfo" element={<UserInfo />}></Route>
          <Route path="/question" element={<UserInfo />}></Route>
          <Route path="/answer" element={<Answer />}></Route>
        </Routes>
      </ContentWrapper>
    </div>
  );
}
export default App;

const ContentWrapper = styled.div`
  margin-top: 60px;
  display: flex;
  justify-content: center; //수평 중앙 정렬
  /* align-items: center; // 수직 중앙 정렬 */
`;
