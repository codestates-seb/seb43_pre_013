import { useMemo, useRef, useState } from "react";
import styled from "styled-components";
import "react-quill/dist/quill.snow.css";
import ReactQuill from "react-quill";
import axios from "axios";
import { Link } from "react-router-dom";

const Container = styled.div`
  min-height: calc(100vh - 60px); //스크롤 했을 시 배경색이 달라지는 문제점 해결
  background-color: #ececec;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  justify-content: flex-start; //상하기준 중심
  align-items: center; //좌우기준 중심
`;

const TitleBox = styled.div`
  display: flex;
  flex-direction: column;
  border-style: solid;
  border-color: #d3d3d3;
  background-color: white;
  padding: 5px;
  width: 850px;
  margin-bottom: 20px;
`;

const TextEditor = styled(ReactQuill)`
  width: 800px;
  height: 250px;
  margin-top: 5px;
  margin-bottom: 40px;
  margin-left: 17px;
  display: flex;
  flex-direction: column;
  overflow-y: auto; //내용초과시 스크롤기능
`;

const TitleInput = styled.input`
  width: 800px;
  padding: 0.3rem;
  border: 1px solid #ccc;
  border-radius: 4px;
  overflow: auto;
  margin-bottom: 3px;
  margin-left: 20px;
`;

const SubmitButton = styled.button`
  margin-left: 660px;
  width: 180px;
  height: 50px;
  font-size: 18px;
  border-radius: 50px;
  background-color: #68bdff;
`;

const SubmitButtonContainer = styled.div`
  padding: 5px;
  margin: 20px;
`;

const TitleName = styled.h2`
  padding: 30px 50px;
  margin: 5px;
  margin-right: 610px;
`;
const SubTitleName = styled.h3`
  margin-top: 10px;
  margin-left: 20px;
`;
const SubDescription = styled.div`
  margin: 2px;
  margin-left: 20px;
`;

const AnswerContainer = styled.div`
  border-style: solid;
  border-color: #d3d3d3;
  background-color: white;
  padding: 5px;
  width: 850px;
  margin-bottom: 20px;
`;

function AskQuestion() {
  const quillRef1 = useRef();
  const quillRef2 = useRef();
  const [title, setTitle] = useState("");
  const [content1, setContent1] = useState("");
  const [content2, setContent2] = useState("");

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

  const handleSubmit = () => {
    const quill1 = quillRef1.current.getEditor();
    const quill2 = quillRef2.current.getEditor();
    const text = quill1.getText() + quill2.getText();
    const data = {
      questionTitle: title,
      questionContent: text,
    };

    axios
      .post(
        "http://ec2-3-36-201-96.ap-northeast-2.compute.amazonaws.com:8080/boards/questions",
        data
      )
      .then((response) => {
        response.json();

        window.location.href = "/";

        console.log(response.data);
      })
      .catch((error) => {
        console.log(error.config.data);
      });
  };

  return (
    <Container>
      <TitleName>Ask a Public Question</TitleName>
      <TitleBox>
        <SubTitleName>Title</SubTitleName>
        <SubDescription>
          Be specific and imagine you are asking a question to another person.
        </SubDescription>
        <TitleInput
          type="text"
          placeholder="e.g. Is there an R function for finding the index of an element in a vector?"
          onChange={(e) => setTitle(e.target.value)}
        />
      </TitleBox>
      <AnswerContainer>
        <SubTitleName>What are the details of your problem?</SubTitleName>
        <SubDescription>
          Introduce the problem and expand on what you put in the title. Minimum
          20 characters.
        </SubDescription>
        <TextEditor
          className="text-editor"
          placeholder="Please type"
          theme="snow"
          ref={quillRef1}
          value={content1}
          onChange={setContent1}
          modules={modules}
        />
      </AnswerContainer>
      <AnswerContainer>
        <SubTitleName>
          What did you try and what were you expecting?
        </SubTitleName>
        <SubDescription>
          Describe what you tried, what you expected to happen, and what
          actually resulted. Minimum 20 characters.
        </SubDescription>
        <TextEditor
          className="text-editor"
          placeholder="Please type"
          theme="snow"
          ref={quillRef2}
          value={content2}
          onChange={setContent2}
          modules={modules}
        />
      </AnswerContainer>
      <SubmitButtonContainer>
        <Link to="/">
          <SubmitButton onClick={handleSubmit}>SUBMIT</SubmitButton>
        </Link>
      </SubmitButtonContainer>
    </Container>
  );
}

export default AskQuestion;
