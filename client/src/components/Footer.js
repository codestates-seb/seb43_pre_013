import styled from "styled-components";
import { ReactComponent as FooterLogo } from "../assets/images/Footer_Logo.svg";

const FooterContainer = styled.footer`
  width: 100%;
  background-color: hsl(210, 8%, 15%);
  color: hsl(210, 8%, 60%);
  .footer-container {
    list-style: none;
    display: flex;
    justify-content: space-between;
    margin: 0;
    padding: 32px 12px 12px;
    width: 100%;
    max-width: 1264px;
    margin: 0 auto;
    .foot-logo {
      flex: 0 0 64px;
      margin: -12px 0 32px;
      a {
        color: hsl(210, 8%, 60%);
      }
    }
    .bot-menu-container {
      display: flex;
      flex: 2 1 auto;
      > ul {
        list-style: none;
        flex: 1 0 auto;
        padding: 0 12px 24px 0;
        > h5 {
          margin: 0 0 12px;
          color: hsl(210, 8%, 75%);
        }
        > li {
          line-height: 2;
          font-size: 13px;
        }
      }
    }
    .sns-copyright {
      display: flex;
      flex-direction: column;
      flex: 1 1 150px;
      font-size: 11px;
      .sns-container {
        > ul {
          list-style: none;
          padding: 0;
          display: flex;
          > li {
            margin-left: 12px;
            padding: 4px 0;
            &:first-child {
              margin: 0;
            }
          }
        }
      }
      .copyright-container {
        margin: auto 0 24px;
      }
    }
  }
`;

const Footer = () => {
  return (
    <FooterContainer>
      <ul className="footer-container">
        <li className="foot-logo">
          <FooterLogo />
        </li>
        <li className="bot-menu-container">
          <ul>
            <h5>STACK OVERFLOW</h5>
            <li>Questions</li>
            <li>Help</li>
          </ul>
          <ul>
            <h5>PRODUCTS</h5>
            <li>Teams</li>
            <li>Advertising</li>
            <li>Collectives</li>
            <li>Talent</li>
          </ul>
          <ul>
            <h5>COMPANY</h5>
            <li>About</li>
            <li>Press</li>
            <li>Work Here</li>
            <li>Legal</li>
            <li>Privacy Policy</li>
            <li>Terms of Service</li>
            <li>Contact Us</li>
            <li>Cookie Settings</li>
            <li>Cookie Policy</li>
          </ul>
          <ul>
            <h5>STACK EXCHANGE NETWORK</h5>
            <li>Technology</li>
            <li>Culture & recreation</li>
            <li>Life & arts</li>
            <li>Science</li>
            <li>Professional</li>
            <li>Business</li>
            <li></li>
            <li>API</li>
            <li>Data</li>
          </ul>
        </li>
        <li className="sns-copyright">
          <div className="sns-container">
            <ul>
              <li>Blog</li>
              <li>FaceBook</li>
              <li>Twitter</li>
              <li>LinkedIn</li>
              <li>Instagram</li>
            </ul>
          </div>
          <div className="copyright-container">
            Site design / logo © 2023 Stack Exchange Inc; user
            <br />
            contributions licensed under CC BY-SA.
            <br />
            rev 2023.4.20.43399
          </div>
        </li>
      </ul>
    </FooterContainer>
  );
};

export default Footer;
