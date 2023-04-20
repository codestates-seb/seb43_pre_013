import styled from "styled-components";
import GoogleLogin from "../components/GoogleLogin";

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
`;

// const Message = styled.h1`
//   font-size: 2rem;
// `;

const Login = () => {
  return (
    <Container>
      {/* <Message>로그인 페이지 입니다</Message> */}
      <GoogleLogin />
    </Container>
  );
};

export default Login;
