import QuestionsHeader from "../components/QuestionHeader";
import QuestionList from "../components/QuestionList";
import styled from "styled-components";
const MainPage = () => {
  return (
    <ContentWrapper>
      <QuestionsHeader />
      <QuestionList />
    </ContentWrapper>
  );
};

const ContentWrapper = styled.div`
  background-color: white;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

export default MainPage;
