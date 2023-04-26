import styled from "styled-components";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import Answer from "./Answer";

const QuestionDetail = () => {
  const [question, setQuestion] = useState({});
  const [contentEditable, setContentEditable] = useState(false);
  const [modifiedQuestionContent, setModifiedQuestionContent] = useState("");

  const { id } = useParams();

  const toggleEditable = () => {
    setContentEditable(!contentEditable);
    setModifiedQuestionContent(question.questionContent);
  };

  const handleContentChange = (e) => {
    setModifiedQuestionContent(e.target.value);
  };

  // const handleSaveClick = () => {
  //   const putData = {
  //     method: "PUT",
  //     headers: {
  //       "Content-Type": "application/json",
  //     },
  //     body: JSON.stringify({
  //       questionContent: modifiedQuestionContent,
  //     }),
  //   };
  //   fetch(
  //     `http://ec2-3-36-201-96.ap-northeast-2.compute.amazonaws.com:8080/boards/questions/${id}`,
  //     putData
  //   )
  //     .then((response) => response.json())
  //     .then((data) => setQuestion(data))
  //     .catch((error) => console.error(error));
  //   setContentEditable(false);
  // };

  // const handleDeleteClick = () => {
  //   console.log(id);
  //   const deleteData = {
  //     method: "DELETE",
  //   };
  //   fetch(
  //     `http://ec2-3-36-201-96.ap-northeast-2.compute.amazonaws.com:8080/boards/questions/${id}`,
  //     deleteData
  //   )
  //     .then(() => {
  //       // Redirect to the list of questions after deleting the question
  //       window.location.href = "/";
  //     })
  //     .catch((error) => console.error(error));
  // };

  //상단에 질문 띄우기위해 가져오는것
  useEffect(() => {
    fetch(
      `http://ec2-3-36-201-96.ap-northeast-2.compute.amazonaws.com:8080/boards/questions/${id}`
    )
      .then((response) => response.json())
      .then((data) => setQuestion(data));
  }, [id]);

  const [comments, setComments] = useState([]);

  useEffect(() => {
    fetch(
      `http://ec2-3-36-201-96.ap-northeast-2.compute.amazonaws.com:8080/boards/answers/${id}`
    )
      .then((response) => response.json())
      .then((data) => setComments(data));
  }, [id]);

  if (!question) {
    return <div>Loading...</div>;
  }

  return (
    <Container>
      <DeatailWrapper>
        <TopHalf>
          <Title>{question.questionTitle}</Title>
          <AskQuestionBtn>Ask Question</AskQuestionBtn>
        </TopHalf>
        <QuestionInfo>
          <GrayText>Asked : {question.questionRegistDate} </GrayText>
          <GrayText>Modified : {question.questionRegistDate} </GrayText>
          <GrayText>View : {question.view}</GrayText>
        </QuestionInfo>
        <BottomHalf>
          {contentEditable ? (
            <textarea
              value={modifiedQuestionContent}
              onChange={handleContentChange}
            />
          ) : (
            question.questionContent
          )}
        </BottomHalf>
        <ButtonContainer>
          <div>
            {contentEditable ? (
              <>
                <button onClick={toggleEditable}>수정취소</button>
                <button>저장하기</button>
              </>
            ) : (
              <>
                <button onClick={toggleEditable}>수정하기</button>
                <button>삭제하기</button>
              </>
            )}
          </div>
        </ButtonContainer>
      </DeatailWrapper>
      <AnswerList>
        {/* 아래는 Answer을 작성하면 /boards/answers/${id}에 저장되도록 하는 기능을 구현해야함 */}
        <List key={comments.answerId}>
          <ol>
            <div>댓글 순서 : {comments.answerId}</div>
            <div>내용 : {comments.answerContent}</div>
          </ol>
        </List>
      </AnswerList>
      <Answer id={id}></Answer>
    </Container>
  );
};

export default QuestionDetail;

const DeatailWrapper = styled.div`
  border: 1px solid #d3d3d3;
  padding: 40px;
  display: flex;
  flex-direction: column;
`;

const List = styled.li`
  border: 1px solid #d3d3d3;
  padding: 10px;
  margin: 5px;
  list-style: none;
  width: 47rem;
  /* border-bottom: 3px solid gray; */
`;

const AnswerList = styled.ul`
  width: 60rem;
  padding: 0px;
  margin: 0;
  list-style: none;
`;

const Container = styled.div`
  display: flex;
  flex-direction: column;
  /* border: 2px solid #c6c5c5; */
  width: 53rem;
  /* height: px; */
  box-sizing: border-box;
  padding: 30px;
  & > * {
    margin-bottom: 20px;
  }
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
  padding-left: 10px;
  /* justify-content: flex-end; // 내부 요소를 오른쪽 끝으로 정렬 */
`;

const QuestionInfo = styled.p`
  color: black;
`;

const GrayText = styled.span`
  color: Gray;
  margin: 0 6px;
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

const ButtonContainer = styled.div``;
