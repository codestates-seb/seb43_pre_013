import styled from "styled-components";

// import AskQuestion from "../components/AskQuestion";
import QuetionDetail from "../components/QuestionDetail";
import Answer from "../components/Answer";
// const Container = styled.div``;

// const Message = styled.h1`
//   font-size: 2rem;
// `;

const QuestionAskPage = () => {
  return (
    <ContentWrapper>
      <QuetionDetail></QuetionDetail>
      <Answer></Answer>
    </ContentWrapper>
  );
};

const ContentWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center; // 수직 중앙 정렬
`;

export default QuestionAskPage;
