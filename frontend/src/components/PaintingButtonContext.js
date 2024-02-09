import React, { createContext, useState } from 'react';

const PaintingButtonContext = createContext();

const PaintingButtonProvider = ({ children }) => {
    const [paintingButtonClicked, setPaintingButtonClicked] = useState(null);

  return (
    <PaintingButtonContext.Provider value={{paintingButtonClicked, setPaintingButtonClicked}}>
      {children}
    </PaintingButtonContext.Provider>
  );
};

export { PaintingButtonProvider, PaintingButtonContext };