import { useMemo, useRef, useState } from "react";
import styled from "styled-components";
import "react-quill/dist/quill.snow.css";
import ReactQuill from "react-quill";
import axios from "axios";

const Container = styled.div`
  min-height: calc(100vh - 60px);
  background-color: white;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
`;

const SubmitButton = styled.button`
  margin-left: 38rem;
  width: 180px;
  height: 50px;
  font-size: 18px;
  border-radius: 50px;
  background-color: #68bdff;
`;

const SubmitButtonContainer = styled.div`
  padding: 5px;
  margin: 10px;
`;

const TextEditor = styled(ReactQuill)`
  width: 50rem;
  height: 250px;
  margin-top: 30px;
  margin-bottom: 40px;
  margin-left: 17px;
  display: flex;
  flex-direction: column;
  overflow-y: auto;
`;

const TitleName = styled.h2`
  padding-top: 50px;
  margin: 0px 600px 0px 0px;
  width: 9rem;
`;

const AnswerContainer = styled.div`
  border-style: solid;
  border-style: none;
  background-color: white;
  display: flex;
  justify-content: center;
  width: 850px;
  height: 300px;
`;

const Answer = (id) => {
  const quillRef = useRef();
  const [content, setContent] = useState("");
  const modules = useMemo(() => {
    return {
      toolbar: {
        container: [
          [{ header: [1, 2, 3, false] }],
          ["bold", "italic", "underline", "strike"],
          ["blockquote"],
          [{ list: "ordered" }, { list: "bullet" }],
          [{ color: [] }, { background: [] }],
          [{ align: [] }, "link", "image"],
        ],
      },
    };
  }, []);

  const handlePostAnswer = () => {
    const quill = quillRef.current.getEditor();
    const text = quill.getText();
    const data = {
      answerId: id,
      answerTitle: "",
      answerContent: text,
    };

    console.log(id);

    axios
      .post(
        `http://ec2-3-36-201-96.ap-northeast-2.compute.amazonaws.com:8080/boards/answers/${id.id}`,
        data
      )
      .then((response) => {
        try {
          const data = response.data;
          console.log(data);
        } catch (error) {
          console.log(error);
        }
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <Container>
      <TitleName>Your Answer</TitleName>
      <AnswerContainer>
        <TextEditor
          className="text-editor"
          placeholder="Please type"
          theme="snow"
          ref={quillRef}
          value={content}
          onChange={setContent}
          modules={modules}
        />
      </AnswerContainer>
      <SubmitButtonContainer>
        <SubmitButton onClick={handlePostAnswer}>Post Your Answer</SubmitButton>
      </SubmitButtonContainer>
    </Container>
  );
};

export default Answer;
