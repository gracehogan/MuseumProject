import React, { useState, useRef, useEffect } from "react";
import '../resources/css/FAQPage.css';
import { FiPlus } from "react-icons/fi";

const FAQPage = () => {
  const [active, setActive] = useState(false);
  const [active2, setActive2] = useState(false);
  const contentRef = useRef(null);
  const contentRef2 = useRef(null);

  useEffect(() => {
    contentRef.current.style.maxHeight = active
      ? `${contentRef.current.scrollHeight}px`
      : "0px";
  }, [contentRef, active]);

  useEffect(() => {
    contentRef2.current.style.maxHeight = active2
      ? `${contentRef2.current.scrollHeight}px`
      : "0px";
  }, [contentRef2, active2]);

  const toggleAccordion = () => {
    setActive(!active);
  };

  const toggleAccordion2 = () => {
    setActive2(!active2);
  };

  return (
    <div className="heading-container">
      <h2>FAQs</h2>
      <div>
        <button
          className={`question-section ${active ? 'active' : ''}`}
          onClick={toggleAccordion}
        >
          <div>
            <div className="question-align">
              <h4 className="question-style">
              What are the typical amenities provided by museums to enhance visitors' experiences?
              </h4>
              <FiPlus
                className={active ? 'question-icon rotate' : 'question-icon'}
              />
            </div>
            <div
              ref={contentRef}
              className={active ? 'answer answer-divider' : 'answer'}
            >
              <p>Museums often provide amenities such as guided tours, audio guides, interactive exhibits, gift shops, cafes/restaurants, and educational programs to enrich visitors' experiences and make their time at the museum more enjoyable and informative.</p>
            </div>
          </div>
        </button>
      </div>

      <div>
        <button
          className={`question-section ${active2 ? 'active' : ''}`}
          onClick={toggleAccordion2}
        >
          <div>
            <div className="question-align">
              <h4 className="question-style">
              How far in advance should I book tickets for a popular museum exhibit to ensure availability?
              </h4>
              <FiPlus
                className={active2 ? 'question-icon rotate' : 'question-icon'}
              />
            </div>
            <div
              ref={contentRef2}
              className={active2 ? 'answer answer-divider' : 'answer'}
            >
              <p>It's advisable to book tickets for popular museum exhibits as early as possible, especially during peak seasons or special events. Many museums offer online booking systems where visitors can reserve tickets in advance to secure their entry and avoid long queues or disappointment due to sold-out tickets. Booking ahead also allows visitors to plan their visit more effectively and ensure they have enough time to explore the museum's collections and exhibits thoroughly.</p>
            </div>
          </div>
        </button>
      </div>

    </div>
  );
};

export default FAQPage;
