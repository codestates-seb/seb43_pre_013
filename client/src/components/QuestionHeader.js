import styled from "styled-components";

const QuestionsHeader = () => {
  return (
    <Container>
      <TopHalf>
        <Title>Top Questions</Title>
        <AskQuestionBtn>Ask Question</AskQuestionBtn>
      </TopHalf>
      <BottomHalf>
        <OptionBtn>Interesting</OptionBtn>
        <OptionBtn>Bountied</OptionBtn>
        <OptionBtn>Hot</OptionBtn>
        <OptionBtn>Week</OptionBtn>
        <OptionBtn>Month</OptionBtn>
      </BottomHalf>
    </Container>
  );
};

const Container = styled.div`
  display: flex;
  flex-direction: column;
  border: 3px solid black;
  width: 800px;
  height: 150px;
  box-sizing: border-box;
  padding: 30px;
`;

const TopHalf = styled.div`
  flex: 1; // 상하로 절반 나누기 위해 공간을 동일하게 할당
  display: flex; // flex를 사용하여 내부 요소를 정렬
  justify-content: space-between;
  margin-bottom: 20px;
`;

const BottomHalf = styled.div`
  flex: 1; // 상하로 절반 나누기 위해 공간을 동일하게 할당
  display: flex; // flex를 사용하여 내부 요소를 정렬
  justify-content: flex-end; // 내부 요소를 오른쪽 끝으로 정렬
`;

const Title = styled.h1`
  color: black;
`;
const AskQuestionBtn = styled.button`
  color: white;
  background-color: blue;
  cursor: pointer;
  border-radius: 4px;
  border: none;
  height: 40px;
  width: 100px;
  // 호버 시 스타일 변경
  &:hover {
    background-color: darkblue;
  }
`;

const OptionBtn = styled.button`
  cursor: pointer;
  border: 1px solid #949ca3;
  background-color: #ffffff;
  color: #5e6871;
  padding: 11px;
  &:hover {
    background-color: #f7f7f8;
  }
`;

export default QuestionsHeader;
