import React, { createContext, useState } from 'react';

const SculptureSearchBarContext = createContext();

const SculptureSearchBarProvider = ({ children }) => {
  const [ sculptureSearchBarContents, setSculptureSearchBarContents] = useState("");

  return (
    <SculptureSearchBarContext.Provider value={{ sculptureSearchBarContents, setSculptureSearchBarContents }}>
      {children}
    </SculptureSearchBarContext.Provider>
  );
};

export { SculptureSearchBarProvider, SculptureSearchBarContext };