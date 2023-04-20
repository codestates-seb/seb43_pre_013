import { useMemo, useRef, useState } from "react";
import "react-quill/dist/quill.snow.css";
import ReactQuill from "react-quill";
import "./askQuestion.css";

function askQuestion() {
  const quillRef = useRef();
  const [content, setContent] = useState("");
  const modules = useMemo(() => {
    return {
      toolbar: {
        container: [
          [{ header: [1, 2, 3, false] }],
          ["bold", "italic", "underline", "strike"],
          ["blockquote"],
          [{ list: "ordered" }, { list: "bullet" }],
          [{ color: [] }, { background: [] }],
          [{ align: [] }, "link", "image"],
        ],
      },
    };
  }, []);
  return (
    <main>
      <h1>ask a public question</h1>
      <div className="titlebox">
        <div className="title">Title</div>
        <div className="description">
          Be specific and imagine you are asking a question to another person.
        </div>
        <input
          type="text"
          placeholder="e.g. Is there an R function for finding the index of an element in a vector?"
        />
      </div>

      <div className="answer-container">
        <div className="head1">What are the details of your problem?</div>
        <div>
          introduce the problem and expand on what you put in the title. Minimum
          20 characters.
        </div>
        <ReactQuill
          className="text-editor"
          placeholder="Please type."
          theme="snow"
          ref={quillRef}
          value={content}
          onChange={setContent}
          modules={modules}
        />
      </div>

      <div className="answer-container">
        <div className="head1">
          what did you try and what were you expecting?
        </div>
        <div>
          Descirbe what you tried, what you expected to happen, and what
          actually resulted. Minimum 20 characters.
        </div>
        <ReactQuill
          className="text-editor"
          placeholder="Please type."
          theme="snow"
          ref={quillRef}
          value={content}
          onChange={setContent}
          modules={modules}
        />
        <div className="submit-button-container">
          <button
            className="submit-button"
            onClick={() => console.log(content)}
          >
            SUBMIT
          </button>
        </div>
      </div>
    </main>
  );
}

export default askQuestion;
