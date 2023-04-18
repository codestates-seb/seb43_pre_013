import { useMemo, useRef, useState } from "react";
import "react-quill/dist/quill.snow.css";
import ReactQuill from "react-quill";
import "./Answer.css";

function Answer() {
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
      <div className="headname">
        <div className="head1">
          What did you try and what were you expecting?
        </div>
        <div className="head2">
          Describe what you tried, what you expected to happen, and what
          actually resulted, Minimum 20 characters.
        </div>
      </div>
      <div className="answer-container">
        <ReactQuill
          className="text-editor"
          placeholder="Please answer"
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
            Post Your Answer
          </button>
        </div>
      </div>
    </main>
  );
}

export default Answer;
