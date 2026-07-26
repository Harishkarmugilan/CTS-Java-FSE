import { useState } from "react";
import Guest from "./Guest";
import User from "./User";

function App() {

    const [isLoggedIn, setIsLoggedIn] = useState(false);

    return (

        <div style={{ textAlign: "center" }}>

            <h1>Ticket Booking App</h1>

            {
                isLoggedIn ?

                    <>
                        <button
                            onClick={() => setIsLoggedIn(false)}
                        >
                            Logout
                        </button>

                        <User />

                    </>

                    :

                    <>
                        <button
                            onClick={() => setIsLoggedIn(true)}
                        >
                            Login
                        </button>

                        <Guest />

                    </>

            }

        </div>

    );

}

export default App;