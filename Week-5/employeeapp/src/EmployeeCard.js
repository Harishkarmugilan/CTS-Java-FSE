import { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard({ employee }) {

    const theme = useContext(ThemeContext);

    return (

<div
  style={{
    border: "1px solid gray",
    padding: "15px",
    margin: "10px",
    borderRadius: "5px",
    backgroundColor: theme === "light" ? "#ffffff" : "#444444",
    color: theme === "light" ? "#000000" : "#ffffff",
    transition: "background-color 0.4s ease, color 0.4s ease"
  }}
>

            <h3>{employee.name}</h3>

            <p>Department : {employee.department}</p>

            <button
                className={theme}
                style={{
                    backgroundColor:
                        theme === "light" ? "#333333" : "#eeeeee",

                    color:
                        theme === "light" ? "white" : "black",

                    padding: "8px 15px",
                    border: "none"
                }}
            >
                View Details
            </button>

        </div>

    );

}

export default EmployeeCard;