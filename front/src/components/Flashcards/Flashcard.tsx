import React, {
  FC,
  useState,
  useEffect,
  useRef,
  MutableRefObject,
} from 'react';

type flashcardAlias = {
  id: string;
  question: string;
  answer: string;
  Bonus: string;
  urgency: string;
  typeOfQuestion: string;
  render: string;
  direction: string;
  topic: string;
  subTopic1: string;
  subTopic2: string;
  chapter: string;
  source: string;
};

const Flashcard: FC<{ flashcard: flashcardAlias }> = (props) => {
  const { question, answer } = props.flashcard;
  const [flip, setFlip] = useState<boolean>(false);
  const [height, setHeight] = useState<number | string>('initial');
  const frontEl = useRef() as MutableRefObject<HTMLDivElement>;
  const backEl = useRef() as MutableRefObject<HTMLDivElement>;
  const setMaxHeight = () => {
    const frontHeight = frontEl.current.getBoundingClientRect().height;
    const backHeight = backEl.current.getBoundingClientRect().height;
    setHeight(Math.max(frontHeight, backHeight, 100));
  };
  useEffect(setMaxHeight, [question, answer]);
  const cardFlip = () => {
    setFlip(!flip);
    setTimeout(() => {
      setFlip(false);
    }, 5000);
  };
  let userInput: ReturnType<typeof setTimeout> | undefined;
  const cardFlipHandler = () => {
    if (!!userInput) {
      clearTimeout(userInput);
    }
    userInput = setTimeout(() => {
      cardFlip();
      userInput = undefined;
    }, 100);
  };
  return (
    <div
      className={`card ${flip ? 'flip' : ''}`}
      style={{ height: height }}
      onClick={cardFlipHandler}
    >
      <div className="front" ref={frontEl}>
        {question}
      </div>
      <div className="back" ref={backEl}>
        <h3>{answer}</h3>
      </div>
    </div>
  );
};

export default Flashcard;
