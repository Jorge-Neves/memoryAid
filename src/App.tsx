import React, { FC } from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import { Routes, Route } from 'react-router';

import Landing from './pages';
import Home from './pages/Home';
import AdvancedCSSCourse from './pages/AdvancedCSSCourse';
import './App.css';

const App: FC = () => {
  return (
    <div className="container">
      <Router>
        <Routes>
          <Route path="/" element={<Landing />} />
          <Route path="/home" element={<Home />} />
          <Route path="/course03" element={<AdvancedCSSCourse />} />
        </Routes>
      </Router>
    </div>
  );
};

export default App;
