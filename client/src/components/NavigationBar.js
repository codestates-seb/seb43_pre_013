import styled from "styled-components";
import { Link } from "react-router-dom";
import { useState } from "react";

const Navbar = styled.nav`
  background-color: #f8f9f9;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0.5rem 2rem;
  /* 상단에 고정 */
  position: fixed;
  top: 0; //추가
  left: 0; //추가
  right: 0;
  height: 60px; //컨텐츠 가려짐을 위해 높이추가
  z-index: 100;
`;

const Logo = styled(Link)`
  color: #222426;
  font-size: 1.5rem;
  font-weight: bold;
  padding: 0.5rem 2rem;
  text-decoration: none;

  &:hover {
    background-color: #e3e6e8;
  }
`;

const Search = styled.input`
  width: 400px;
  padding: 0.5rem;
  font-size: 1rem;
  border: 1px solid #bbbfc4;
  border-radius: 4px;
`;

const NavItems = styled.div`
  display: flex;
  align-items: center;
  width: 270px;
`;

const NavLink = styled(Link)`
  color: black;
  font-size: 1rem;
  text-decoration: none;
  margin-left: 1rem;

  &:hover {
    text-decoration: underline;
  }
`;
// 버튼 스타일(상속을 위해 기본 스타일링)
const Button = styled(Link)`
  text-decoration: none;
  font-size: 1rem;
  font-weight: bold;
  border-radius: 4px;
  padding: 0.5rem 1rem;
  margin-left: 1rem;
  cursor: pointer;
`;

const LoginButton = styled(Button)`
  border: 1px solid #6f9bbd;
  color: #0d496b;
  background-color: #e3ecf3;
  &:hover {
    background-color: #a7cde7;
  }
`;

const SignUpButton = styled(Button)`
  border: 1px solid #0368c3;
  color: #ffffff;
  background-color: #4393f7;
  &:hover {
    background-color: #3172c6;
  }
`;

// 로그인 성공 시 사용자 정보 표시 컴포넌트
const UserInfo = styled.div`
  font-size: 1rem;
  margin-left: 1rem;
`;

function NavigationBar() {
  const [isLogin, setIsLogin] = useState(false);
  return (
    <Navbar>
      <Logo to="/">StackOverflow</Logo>

      <Search type="text" placeholder="Search..." />
      <NavItems>
        {isLogin ? (
          <UserInfo>로그인에 성공했습니다.</UserInfo>
        ) : (
          <>
            <NavLink to="/userinfo">Users</NavLink>
            <LoginButton onClick={() => setIsLogin(true)} to="/login">
              Login
            </LoginButton>
            <SignUpButton>SignUp</SignUpButton>
          </>
        )}
      </NavItems>
    </Navbar>
  );
}

export default NavigationBar;
