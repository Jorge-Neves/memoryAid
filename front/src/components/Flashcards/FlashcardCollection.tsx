import React, { FC } from 'react';

import Flashcard from './Flashcard';
import FlashcardMultiChoice from './FlashcardMultiChoice';

type flashcardMultiChoiceAlias = {
  id: string;
  question: string;
  answer: string;
  options: string[];
}[];

type flashcardMultiChoiceMapAlias = {
  id: string;
  question: string;
  answer: string;
  options: string[];
};

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

type flashcardMapAlias = {
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

const FlashcardCollection: FC<{
  flashcardsMultiChoices: flashcardMultiChoiceAlias;
  flashcards: flashcardAlias;
}> = (props) => {
  const { flashcardsMultiChoices, flashcards } = props;
  return (
    <div className="card-grid">
      <h1>FlashcardCollection</h1>
      {flashcardsMultiChoices.map(
        (flashcardMultiChoice: flashcardMultiChoiceMapAlias) => {
          return (
            <FlashcardMultiChoice
              flashcardMultiChoice={flashcardMultiChoice}
              key={flashcardMultiChoice.id}
            />
          );
        }
      )}
      {flashcards.map((flashcard: flashcardMapAlias) => {
        return <Flashcard flashcard={flashcard} key={flashcard.id} />;
      })}
    </div>
  );
};

export default FlashcardCollection;
