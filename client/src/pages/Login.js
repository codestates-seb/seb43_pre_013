import styled from "styled-components";
import GoogleLogin from "../components/GoogleLogin";

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
`;

const Login = () => {
  return (
    <Container>
      <GoogleLogin />
    </Container>
  );
};

export default Login;
