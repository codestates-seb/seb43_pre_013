import styled from "styled-components";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import Answer from "./Answer";
import axios from "axios";

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

  useEffect(() => {
    fetch(
      `http://ec2-3-36-201-96.ap-northeast-2.compute.amazonaws.com:8080/boards/questions/${id}`
    )
      .then((response) => response.json())
      .then((data) => setQuestion(data));
  }, [id]);

  const [comments, setComments] = useState([]);

  const handleCommentSubmit = (value) => {
    const data = {
      text: value,
    };

    axios
      .post(
        `http://ec2-3-36-201-96.ap-northeast-2.compute.amazonaws.com:8080/boards/comm/${id}`,
        data
      )
      .then((response) => {
        response.json();
        window.location.href = "/";
        console.log(response.data);
      });
    // .catch((error) => {
    //   console.log(error.config.data);
    // });
  };

  useEffect(() => {
    fetch(
      `http://ec2-3-36-201-96.ap-northeast-2.compute.amazonaws.com:8080/boards/questions/${id}`
    )
      .then((response) => response.json())
      .then((data) => {
        setComments(data.answers);
      });
  }, [id]);

  if (!question) {
    return <div>Loading...</div>;
  }

  const [commentInput, setCommentInput] = useState("");

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
      <Title>댓글</Title>
      <CommentForm>
        {comments.map((ans) => (
          <div key={ans.answerId}>
            {ans.comments.length !== 0 &&
              ans.comments.map((el) => (
                <div key={el.commentId}>답글 : {el.text}</div>
              ))}
          </div>
        ))}
        <textarea
          value={commentInput}
          onChange={(e) => setCommentInput(e.target.value)}
        />
        <CButton onClick={() => handleCommentSubmit(commentInput)}>
          답변달기
        </CButton>
      </CommentForm>
      <Title>답변</Title>
      <AnswerList>
        {comments.map((ans) => (
          <List key={ans.answerId}>
            <ol>
              <h3>내용 : {ans.answerContent}</h3>
            </ol>
          </List>
        ))}
      </AnswerList>
      <Answer id={id}></Answer>
    </Container>
  );
};

export default QuestionDetail;

const CommentForm = styled.div`
  margin-left: 40px;
  border: 1px solid lightgray;
  padding: 30px;
  margin-right: 28px;
  display: flex;
  flex-direction: column;
`;

const CButton = styled.button`
  /* width: 50px;
  height: 50px; */
`;

const AnswerList = styled.ul`
  width: 60rem;
  padding: 0px;
  margin: 0;
  list-style: none;
`;

const List = styled.li`
  border: 1px solid #d3d3d3;
  padding: 30px;
  margin: 5px;
  list-style: none;
  width: 44rem;
  /* display: flex;
  flex-direction: column; */
`;

const DeatailWrapper = styled.div`
  border: 1px solid #d3d3d3;
  padding: 40px;
  display: flex;
  flex-direction: column;
`;

const Container = styled.div`
  display: flex;
  flex-direction: column;
  width: 53rem;
  box-sizing: border-box;
  padding: 30px;
  & > * {
    margin-bottom: 20px;
  }
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
  padding-left: 10px;
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
  &:hover {
    background-color: darkblue;
  }
`;

const ButtonContainer = styled.div``;
