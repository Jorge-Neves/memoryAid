import React, { FC, useState } from 'react';

import flashcardsMultiChoiceList from '../../Questions/set1.json';
import flashcardList from '../../Questions/N01JavaBasics.json';
import FlashcardCollection from '../../components/Flashcards/FlashcardCollection';

type flashcardMultiChoiceAlias = {
  id: string;
  question: string;
  answer: string;
  options: string[];
}[];

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
}[];

const Home: FC = () => {
  const [flashcardsMultiChoices, setFlashcardsMultiChoice] =
    useState<flashcardMultiChoiceAlias>(flashcardsMultiChoiceList);
  const [flashcards, setFlashcards] = useState<flashcardAlias>(flashcardList);
  return (
    <div className="container">
      <FlashcardCollection
        flashcardsMultiChoices={flashcardsMultiChoices}
        flashcards={flashcards}
      />
    </div>
  );
};

export default Home;
