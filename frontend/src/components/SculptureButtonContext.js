import React, { createContext, useState } from 'react';

const SculptureButtonContext = createContext();

const SculptureButtonProvider = ({ children }) => {
    const [sculptureButtonClicked, setSculptureButtonClicked] = useState(null);

  return (
    <SculptureButtonContext.Provider value={{sculptureButtonClicked, setSculptureButtonClicked}}>
      {children}
    </SculptureButtonContext.Provider>
  );
};

export { SculptureButtonProvider, SculptureButtonContext };