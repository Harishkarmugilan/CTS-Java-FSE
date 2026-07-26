import { useState } from "react";
import { useEffect } from "react";

import ThemeContext from "./ThemeContext";
import EmployeesList from "./EmployeesList";

function App() {

    const [theme, setTheme] = useState("light");
      useEffect(() => {
    document.body.style.backgroundColor =
      theme === "light" ? "#eeeeee" : "#333333";

    document.body.style.color =
      theme === "light" ? "black" : "white";
  }, [theme]);

    return (

        <ThemeContext.Provider value={theme}>

            <div style={{ textAlign: "center" }}>

                <h1>Employee Management</h1>

                <button
                    onClick={() =>
                        setTheme(
                            theme === "light"
                                ? "dark"
                                : "light"
                        )
                    }

                    style={{
                        backgroundColor:
                            theme === "light" ? "black" : "white",
                        color:
                            theme === "light" ? "white" : "black",
                        padding: "8px 15px",
                    }}
                >
                    Change Theme
                </button>

                <EmployeesList />

            </div>

        </ThemeContext.Provider>

    );

}

export default App;