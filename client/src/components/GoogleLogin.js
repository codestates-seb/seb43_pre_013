// GoogleLoginButton.js

const GoogleLogin = () => {
  const clientId = "YOUR_GOOGLE_CLIENT_ID";
  const redirectUri = "YOUR_BACKEND_SERVER_URL/login/oauth2/code/google";

  const handleClick = () => {
    const url = `https://accounts.google.com/o/oauth2/v2/auth?scope=profile%20email&access_type=online&response_type=code&client_id=${clientId}&redirect_uri=${redirectUri}`;
    window.location.href = url;
  };

  return <button onClick={handleClick}>Login with Google</button>;
};

export default GoogleLogin;
