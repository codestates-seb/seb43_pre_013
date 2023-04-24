import styled from "styled-components";
import QuestionDetail from "../components/QuestionDetail";
import Answer from "../components/Answer";

const QuestionAskPage = () => {
  return (
    <ContentWrapper>
      <QuestionDetailWrapper>
        <QuestionDetail></QuestionDetail>
      </QuestionDetailWrapper>
      <Answer></Answer>
    </ContentWrapper>
  );
};

const QuestionDetailWrapper = styled.div`
  margin: 1rem; // margin 값 설정
`;

const ContentWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center; // 수직 중앙 정렬
  background-color: #ececec;
`;

export default QuestionAskPage;
