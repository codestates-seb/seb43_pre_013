import styled from "styled-components";

const ErrorWrapper = styled.h1`
  min-height: calc(100vh - 60px); //스크롤 했을 시 배경색이 달라지는 문제점 해결
  background-color: #ececec;
  display: flex;
  justify-content: center; //상하기준 중심
  align-items: center; //좌우기준 중심
  font-size: 4em;
`;

const ErrorPage = () => {
  return <ErrorWrapper>Page Not Found</ErrorWrapper>;
};

export default ErrorPage;
