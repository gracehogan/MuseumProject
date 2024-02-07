import React, { useState, useRef, useEffect } from "react";
import '../resources/css/FAQPage.css';
import { FiPlus } from "react-icons/fi";


const FAQPage = () => {
  const [active3, setActive3] = useState(false);
  const [active4, setActive4] = useState(false);
  const [active5, setActive5] = useState(false);
  const [active6, setActive6] = useState(false);
  const [active7, setActive7] = useState(false);
  const [active8, setActive8] = useState(false);

  const contentRef3 = useRef(null);
  const contentRef4 = useRef(null);
  const contentRef5 = useRef(null);
  const contentRef6 = useRef(null);
  const contentRef7 = useRef(null);
  const contentRef8 = useRef(null);

  const toggleAccordion3 = () => {
    setActive3(!active3);
  };

  const toggleAccordion4 = () => {
    setActive4(!active4);
  };

  const toggleAccordion5 = () => {
    setActive5(!active5);
  };

  const toggleAccordion6 = () => {
    setActive6(!active6);
  };

  const toggleAccordion7 = () => {
    setActive7(!active7);
  };

  const toggleAccordion8 = () => {
    setActive8(!active8);
  };

  useEffect(() => {
    if (contentRef3.current) {
      contentRef3.current.style.maxHeight = active3
        ? `${contentRef3.current.scrollHeight}px`
        : "0px"; // Adjust the value as needed
    }
  }, [active3]);

  useEffect(() => {
    if (contentRef4.current) {
      contentRef4.current.style.maxHeight = active4
        ? `${contentRef4.current.scrollHeight}px`
        : "0px"; // Adjust the value as needed
    }
  }, [active4]);

  useEffect(() => {
    if (contentRef5.current) {
      contentRef5.current.style.maxHeight = active5
        ? `${contentRef5.current.scrollHeight}px`
        : "0px"; // Adjust the value as needed
    }
  }, [active5]);

  useEffect(() => {
    if (contentRef6.current) {
      contentRef6.current.style.maxHeight = active6
        ? `${contentRef6.current.scrollHeight}px`
        : "0px"; // Adjust the value as needed
    }
  }, [active6]);

  useEffect(() => {
    if (contentRef7.current) {
      contentRef7.current.style.maxHeight = active7
        ? `${contentRef7.current.scrollHeight}px`
        : "0px"; // Adjust the value as needed
    }
  }, [active7]);

  useEffect(() => {
    if (contentRef8.current) {
      contentRef8.current.style.maxHeight = active8
        ? `${contentRef8.current.scrollHeight}px`
        : "0px"; // Adjust the value as needed
    }
  }, [active8]);

  
  return (
    <div className="heading-container">
      <h2>FAQs</h2>
      <div>
        <button
          className={`question-section ${active3 ? 'active' : ''}`}
          onClick={toggleAccordion3}
        >
          <div>
            <div className="question-align">
              <h4 className="question-style">
                How long does it take to receive a booking confirmation?
              </h4>
              <FiPlus
                className={active3 ? 'question-icon rotate' : 'question-icon'}
              />
            </div>
            <div
              ref={contentRef3}
              className={active3 ? 'answer answer-divider' : 'answer'}
            >
              <p>Booking confirmations are typically sent via email immediately after the booking process is completed. Please check your inbox, including the spam or junk folder, for the confirmation email.</p>
            </div>
          </div>
        </button>
      </div>

      <div>
        <button
          className={`question-section ${active4 ? 'active' : ''}`}
          onClick={toggleAccordion4}
        >
          <div>
            <div className="question-align">
              <h4 className="question-style">
                Are there any age restrictions for visiting the museum?
              </h4>
              <FiPlus
                className={active4 ? 'question-icon rotate' : 'question-icon'}
              />
            </div>
            <div
              ref={contentRef4}
              className={active4 ? 'answer answer-divider' : 'answer'}
            >
              <p>The museum welcomes visitors of all ages. However, children under the age of 12 must be accompanied by an adult.</p>
            </div>
          </div>
        </button>
      </div>

      <div>
        <button
          className={`question-section ${active5 ? 'active' : ''}`}
          onClick={toggleAccordion5}
        >
          <div>
            <div className="question-align">
              <h4 className="question-style">
                Is the museum accessible to visitors with disabilities?
              </h4>
              <FiPlus
                className={active5 ? 'question-icon rotate' : 'question-icon'}
              />
            </div>
            <div
              ref={contentRef5}
              className={active5 ? 'answer answer-divider' : 'answer'}
            >
              <p>Yes, the museum is fully accessible to visitors with disabilities. We provide wheelchair ramps, elevators, and accessible restrooms to ensure everyone can enjoy the museum's exhibits and facilities.</p>
            </div>
          </div>
        </button>
      </div>

      <div>
        <button
          className={`question-section ${active6 ? 'active' : ''}`}
          onClick={toggleAccordion6}
        >
          <div>
            <div className="question-align">
              <h4 className="question-style">
                Can visitors take photographs of the museum's paintings and sculptures?
              </h4>
              <FiPlus
                className={active6 ? 'question-icon rotate' : 'question-icon'}
              />
            </div>
            <div
              ref={contentRef6}
              className={active6 ? 'answer answer-divider' : 'answer'}
            >
              <p>Photography for personal, non-commercial use is allowed in most areas of the museum. However, flash photography, tripods, and selfie sticks are not permitted. Please respect the artwork and refrain from touching the exhibits.</p>
            </div>
          </div>
        </button>
      </div>

      <div>
        <button
          className={`question-section ${active7 ? 'active' : ''}`}
          onClick={toggleAccordion7}
        >
          <div>
            <div className="question-align">
              <h4 className="question-style">
                Can I get a refund or change my ticket booking?
              </h4>
              <FiPlus
                className={active7 ? 'question-icon rotate' : 'question-icon'}
              />
            </div>
            <div
              ref={contentRef7}
              className={active7 ? 'answer answer-divider' : 'answer'}
            >
              <p>Refunds and changes to ticket bookings are subject to the museum's policies. Please contact our ticketing office or refer to the terms and conditions outlined during the booking process for information on refunds, changes, and cancellation policies.</p>
            </div>
          </div>
        </button>
      </div>

      <div>
        <button
          className={`question-section ${active8 ? 'active' : ''}`}
          onClick={toggleAccordion8}
        >
          <div>
            <div className="question-align">
              <h4 className="question-style">
                Does the museum offer guided tours?
              </h4>
              <FiPlus
                className={active8 ? 'question-icon rotate' : 'question-icon'}
              />
            </div>
            <div
              ref={contentRef8}
              className={active8 ? 'answer answer-divider' : 'answer'}
            >
              <p>Yes, the museum offers guided tours conducted by knowledgeable staff members or trained guides. Guided tours provide insights into the museum's collections, history, and significant artworks. Advanced booking may be required for certain tours.</p>
            </div>
          </div>
        </button>
      </div>
    </div>
  );
};

export default FAQPage;
