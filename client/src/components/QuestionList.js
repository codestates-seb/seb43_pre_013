import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import styled from "styled-components";

const Container = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  border-left: 3px solid lightgray;
  min-height: 100%;
`;

const QuestionList = styled.ul`
  width: 60rem;
  padding: 0px;
  margin-top: 20px;
  list-style: none;
`;

const List = styled.li`
  padding: 10px;
  margin-bottom: 15px;
  width: 58.5rem;
  border-bottom: 3px solid lightgray;
`;

const QuestionListPage = () => {
  const fetchData = () => {
    fetch(
      "http://ec2-3-36-201-96.ap-northeast-2.compute.amazonaws.com:8080/boards/questions?option=1"
    )
      .then((response) => response.json())
      .then((data) => setQuestionList(data));
  };

  const [questionList, setQuestionList] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <Container>
      {/* <ListTitle>질문 목록</ListTitle> */}
      <QuestionList>
        {questionList.map((el) => (
          <List key={el.questionId}>
            <StyledLink to={`/boards/answer/${el.questionId}`}>
              {/* <div>순서 : {el.questionId}</div>  */}
              <div>제목 : {el.questionTitle}</div>
              <div>등록일 : {el.questionRegistDate}</div>
              <div>조회수 : {el.view}</div>
            </StyledLink>
          </List>
        ))}
      </QuestionList>
    </Container>
  );
};

export default QuestionListPage;

const StyledLink = styled(Link)`
  text-decoration: none;
`;
