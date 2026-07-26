import { useState } from "react";
import ListofPlayers from "./ListofPlayers";
import IndianPlayers from "./IndianPlayers";

function App() {

    const [flag, setFlag] = useState(true);

    return (
        <div style={{ textAlign: "center", marginTop: "20px" }}>

            <button onClick={() => setFlag(!flag)}>
                {flag ? "Show Indian Players" : "Show Player List"}
            </button>

            <hr />

            {flag ? <ListofPlayers /> : <IndianPlayers />}

        </div>
    );
}

export default App;