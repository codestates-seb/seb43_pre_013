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
  align-items: center; // 수직 중앙 정렬
`;

export default MainPage;
