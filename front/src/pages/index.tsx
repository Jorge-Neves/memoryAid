import React, { FC } from 'react';
import { NavLink } from 'react-router-dom';

const Landing: FC = () => {
  return (
    <>
      <h1>Landing</h1>
      <div className="navbar">
        <NavLink to="/">Landing</NavLink>
        <NavLink to="/home">Home</NavLink>
        <NavLink to="/course03">Advanced CSS Course</NavLink>
      </div>
    </>
  );
};

export default Landing;
