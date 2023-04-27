import styled from "styled-components";

const ErrorWrapper = styled.h1`
  min-height: calc(100vh - 60px);
  background-color: #ececec;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 4em;
`;

const ErrorPage = () => {
  return <ErrorWrapper>Page Not Found</ErrorWrapper>;
};

export default ErrorPage;
