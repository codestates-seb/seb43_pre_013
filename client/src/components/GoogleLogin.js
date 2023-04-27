import styled from "styled-components";

const Button = styled.button`
  background-color: white;
  color: #737373;
  border: 1px solid #737373;
  border-radius: 4px;
  padding: 8px 16px;
  cursor: pointer;

  &:hover {
    background-color: #f2f2f2;
    border-color: #737373;
  }
`;

const Logo = styled.img`
  height: 20px;
  margin-right: 8px;
  vertical-align: middle;
`;

const StyleLink = styled.a`
  color: #737373;
  text-decoration: none;
`;

const GoogleLogin = () => {
  const host = "http:host";
  const oauthEndpoint = "/oauth2/authorization/google";
  const redirectUri = "https://http:host/login/oauth2/code/google";

  const url = `${host}${oauthEndpoint}?redirect_uri=${redirectUri}`;
  const imgScr = "https://developers.google.com/identity/images/g-logo.png";

  return (
    <Button>
      <Logo src={imgScr} alt="Google Logo" />
      <StyleLink href={url}>Login with Google</StyleLink>
    </Button>
  );
};

export default GoogleLogin;
