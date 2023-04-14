import styled from "styled-components";

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
`;

const Message = styled.h1`
  font-size: 2rem;
`;

const Login = () => {
  return (
    <Container>
      <Message>로그인 페이지 입니다</Message>
    </Container>
  );
};

export default Login;
