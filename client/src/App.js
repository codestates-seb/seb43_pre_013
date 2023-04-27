import NavigationBar from "./components/NavigationBar";
import AskQuestion from "./components/AskQuestion";

import MainPage from "./pages/MainPage";
import Login from "./pages/Login";
import UserInfo from "./pages/UserInfo";
import QuestionAskPage from "./pages/QuestionAskPage";
import ErrorPage from "./pages/ErrorPage";

import { Route, Routes } from "react-router-dom";
import styled from "styled-components";

const App = () => {
  return (
    <div className="App">
      <NavigationBar />
      <ContentWrapper>
        <Routes>
          <Route path="/" element={<MainPage />}></Route>
          <Route path="/login" element={<Login />}></Route>
          <Route path="/userinfo" element={<UserInfo />}></Route>
          <Route
            path="/boards/answer/:id"
            element={<QuestionAskPage />}
          ></Route>
          <Route path="/ask" element={<AskQuestion />}></Route>
          <Route path="/*" element={<ErrorPage />} />
        </Routes>
      </ContentWrapper>
    </div>
  );
};
export default App;

const ContentWrapper = styled.div`
  margin-top: 60px;
`;
