import React, {
  FC,
  useState,
  useEffect,
  useRef,
  MutableRefObject,
} from 'react';

type flashcardMultiChoiceAlias = {
  id: string;
  question: string;
  answer: string;
  options: string[];
};

const FlashcardMultiChoice: FC<{
  flashcardMultiChoice: flashcardMultiChoiceAlias;
}> = (props) => {
  const { question, answer, options } = props.flashcardMultiChoice;
  const [flip, setFlip] = useState<boolean>(false);
  const [height, setHeight] = useState<number | string>('initial');
  const frontEl = useRef() as MutableRefObject<HTMLDivElement>;
  const backEl = useRef() as MutableRefObject<HTMLDivElement>;
  const setMaxHeight = () => {
    const frontHeight = frontEl.current.getBoundingClientRect().height;
    const backHeight = backEl.current.getBoundingClientRect().height;
    setHeight(Math.max(frontHeight, backHeight, 100));
  };
  useEffect(setMaxHeight, [question, answer, options]);
  const cardFlip = () => {
    setFlip(!flip);
    setTimeout(() => {
      setFlip(false);
    }, 5000);
  };
  useEffect(() => {
    window.addEventListener('resize', setMaxHeight);
    return () => window.removeEventListener('resize', setMaxHeight);
  });
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
  //Randomized choices array with
  //Fisher-Yates Shuffle algorithm
  const shuffled = (array: string[]) => {
    const copy = array.slice();
    let result = [];
    while (copy.length > 0) {
      const randomIndex = Math.floor(Math.random() * copy.length);
      result.push(copy[randomIndex]);
      copy.splice(randomIndex, 1);
    }
    return result;
  };
  const shuffledOptions = shuffled(options);

  return (
    <div
      className={`card ${flip ? 'flip' : ''}`}
      style={{ height: height }}
      onClick={cardFlipHandler}
    >
      <div className="front" ref={frontEl}>
        {question}
        <div className="flashcard-options">
          {shuffledOptions.map((option) => {
            return <div className="flashcard-option">{option}</div>;
          })}
        </div>
      </div>
      <div className="back" ref={backEl}>
        <h3>{answer}</h3>
      </div>
    </div>
  );
};

export default FlashcardMultiChoice;
