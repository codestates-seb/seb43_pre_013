import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import styled from "styled-components";

const Container = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  min-height: 100%;
`;

const QuestionList = styled.ul`
  width: 60rem;
  padding: 0px;
  margin: 0;
  list-style: none;
`;

const List = styled.li`
  padding: 10px;
  margin-bottom: 20px;
  list-style: none;
  width: 58.5rem;
  border-bottom: 3px solid gray;
`;

const ListTitle = styled.h2`
  border-bottom: 2px solid gray;
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
      <ListTitle>질문 목록</ListTitle>
      <QuestionList>
        {questionList.map((el) => (
          <List key={el.questionId}>
            <Link to={`/boards/answer/${el.questionId}`}>
              <ol>
                <div>순서 : {el.questionId}</div>
                <div>제목 : {el.questionTitle}</div>
                <div>등록일 : {el.questionRegistDate}</div>
                <div>조회수 : {el.view}</div>
              </ol>
            </Link>
          </List>
        ))}
      </QuestionList>
    </Container>
  );
};

export default QuestionListPage;
