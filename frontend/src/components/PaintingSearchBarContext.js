import React, { createContext, useState } from 'react';

const PaintingSearchBarContext = createContext();

const PaintingSearchBarProvider = ({ children }) => {
  const [ paintingSearchBarContents, setPaintingSearchBarContents] = useState("");

  return (
    <PaintingSearchBarContext.Provider value={{ paintingSearchBarContents, setPaintingSearchBarContents }}>
      {children}
    </PaintingSearchBarContext.Provider>
  );
};

export { PaintingSearchBarProvider, PaintingSearchBarContext };