import { useState, useEffect } from "react";
import axios from "axios";
import styled from "styled-components";
import QuestionDetail from "../components/QuestionDetail";
// import Answer from "../components/Answer";

const QuestionAskPage = () => {
  const [questionData, setQuestionData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await axios.get(
          "http://ec2-3-36-201-96.ap-northeast-2.compute.amazonaws.com:8080/boards/questions?option=1"
        );
        setQuestionData(response.data);
      } catch (error) {
        setError(error);
      }
      setLoading(false);
    };
    fetchData();
  }, []);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error.message}</div>;

  return (
    <ContentWrapper>
      <QuestionDetailWrapper>
        <QuestionDetail question={questionData}></QuestionDetail>
      </QuestionDetailWrapper>
    </ContentWrapper>
  );
};

const QuestionDetailWrapper = styled.div`
  margin: 1rem;
`;

const ContentWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: white;
`;

export default QuestionAskPage;
