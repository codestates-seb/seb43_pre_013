import QuestionsHeader from "../components/QuestionHeader";
import QuestionContainer from "../components/QuestionContainer/QuestionsContainer";
import styled from "styled-components";
const MainPage = () => {
  return (
    <ContentWrapper>
      <QuestionsHeader />
      <QuestionContainer />
    </ContentWrapper>
  );
};

const ContentWrapper = styled.div`
  margin-top: 60px;
  display: flex;
  flex-direction: column;
  //수평 중앙 정렬
  align-items: center; // 수직 중앙 정렬
`;

export default MainPage;
