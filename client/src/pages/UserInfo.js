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

const UserInfo = () => {
  return (
    <Container>
      <Message>유저정보 페이지입니다.</Message>
    </Container>
  );
};

export default UserInfo;
