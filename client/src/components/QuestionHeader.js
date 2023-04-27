import styled from "styled-components";
import { Link } from "react-router-dom";

const QuestionsHeader = () => {
  return (
    <Container>
      <TopHalf>
        <Title>Top Questions</Title>
        <AskQuestionBtn to="/ask">Ask Question</AskQuestionBtn>
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
  border: 2px solid black;
  width: 60rem;
  height: 12rem;
  box-sizing: border-box;
  padding: 30px;
`;

const TopHalf = styled.div`
  flex: 1;
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
`;

const BottomHalf = styled.div`
  flex: 1;
  display: flex;
  justify-content: flex-end;
`;

const Title = styled.h1``;

const StyledLink = styled(Link)`
  color: white;
  background-color: blue;
  cursor: pointer;
  border-radius: 4px;
  border: none;
  height: 2rem;
  width: 6rem;
  font-size: 0.9em;
  text-decoration: none;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 4px;

  &:hover {
    background-color: darkblue;
  }
`;

const AskQuestionBtn = () => {
  return <StyledLink to="/ask">Ask Question</StyledLink>;
};

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
