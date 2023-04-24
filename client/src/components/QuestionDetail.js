import styled from "styled-components";

const QuetionDetail = () => {
  return (
    <Container>
      <TopHalf>
        <Title>안녕하세요</Title>
        <AskQuestionBtn>Ask Question</AskQuestionBtn>
      </TopHalf>
      <QuestionInfo>
        <GrayText>Asked </GrayText> today
        <GrayText>Modified </GrayText> today
        <GrayText>Viewed </GrayText> today
      </QuestionInfo>
      <BottomHalf>
        asdandroid exported true but console giving me error that Manifest
        merger failed : android:exported needs to be explicitly specified for
        element
        dexterous.flutterlocalnotifications.ScheduledNotificationBootReceiver
        Apps targeting Android 12 and higher are required to specify an explicit
        value for android:exported when the corresponding component has an
      </BottomHalf>
      <ButtonContainer>
        <GrayA>Edit</GrayA>
        <GrayA>Delete</GrayA>
      </ButtonContainer>
    </Container>
  );
};

export default QuetionDetail;

const Container = styled.div`
  display: flex;
  flex-direction: column;
  border: 2px solid #c6c5c5;
  width: 53rem;
  /* height: px; */
  box-sizing: border-box;
  padding: 30px;
  & > * {
    margin-bottom: 20px;
  }
`;

const TopHalf = styled.div`
  flex: 1; // 상하로 절반 나누기 위해 공간을 동일하게 할당
  display: flex; // flex를 사용하여 내부 요소를 정렬
  justify-content: space-between;
  margin-bottom: 20px;
`;

const BottomHalf = styled.div`
  flex: 1; // 상하로 절반 나누기 위해 공간을 동일하게 할당
  display: flex; // flex를 사용하여 내부 요소를 정렬
  /* justify-content: flex-end; // 내부 요소를 오른쪽 끝으로 정렬 */
`;

const QuestionInfo = styled.p`
  color: black;
`;

const GrayText = styled.span`
  color: Gray;
  margin: 0 6px;
`;

const Title = styled.h1`
  color: black;
`;
const AskQuestionBtn = styled.button`
  color: white;
  background-color: blue;
  cursor: pointer;
  border-radius: 4px;
  border: none;
  height: 40px;
  width: 100px;
  // 호버 시 스타일 변경
  &:hover {
    background-color: darkblue;
  }
`;

const ButtonContainer = styled.div``;

const GrayA = styled.a`
  /* 여기에서 버튼에 대한 스타일을 적용할 수 있습니다. */
  color: Gray;
  margin: 0 6px;
`;
