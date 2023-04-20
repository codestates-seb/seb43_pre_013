import React, { useState } from "react"; // eslint-disable-line
import DummyList from "./DummyList";
import styles from "./QuestionsContainer.module.css";

function QuestionContainer() {
  const itemsPerPage = 5;
  const totalPages = Math.ceil(DummyList.length / itemsPerPage);

  const [currentPage, setCurrentPage] = useState(1);

  const handlePrevPageClick = () => {
    if (currentPage > 1) {
      setCurrentPage(currentPage - 1);
    }
  };

  const handleNextPageClick = () => {
    if (currentPage < totalPages) {
      setCurrentPage(currentPage + 1);
    }
  };

  const start = (currentPage - 1) * itemsPerPage;
  const end = start + itemsPerPage;

  const currentPageItems = DummyList.slice(start, end);

  const prevLink = (
    <button onClick={handlePrevPageClick} disabled={currentPage === 1}>
      이전 페이지
    </button>
  );

  const nextLink = (
    <button onClick={handleNextPageClick} disabled={currentPage === totalPages}>
      다음 페이지
    </button>
  );

  return (
    <div className={styles.ListContainer}>
      <ul>
        {currentPageItems.map((answer) => (
          <li className={styles.content} key={answer.answerId}>
            <h3 className={styles.Title}>{answer.answerTitle}</h3>
            <p className={styles.miniContent}>{answer.answerContent}</p>
            <p className={styles.end}>
              <span className={styles.author}>{answer.user} </span>
              <span className={styles.day}>
                {new Date(answer.answerRegistDate).toLocaleDateString("ko-kr")}
              </span>
            </p>
          </li>
        ))}
      </ul>
      <div>
        {prevLink} {nextLink}
      </div>
    </div>
  );
}

export default QuestionContainer;
