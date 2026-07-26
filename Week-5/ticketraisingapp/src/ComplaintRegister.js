import { useState } from "react";
import "./App.css";

function ComplaintRegister() {

    const [employeeName, setEmployeeName] = useState("");
    const [complaint, setComplaint] = useState("");

    function handleSubmit(event) {
        event.preventDefault();

        const referenceNumber =
            Math.floor(Math.random() * 1000000);

        alert(
            `Complaint Registered Successfully!\nReference Number: ${referenceNumber}`
        );

        setEmployeeName("");
        setComplaint("");
    }

    return (
        <div className="container">

            <form onSubmit={handleSubmit}>

                <h2>Ticket Raising System</h2>

                <label>Employee Name</label>

                <input
                    type="text"
                    value={employeeName}
                    onChange={(e) => setEmployeeName(e.target.value)}
                    required
                />

                <label>Complaint</label>

                <textarea
                    value={complaint}
                    onChange={(e) => setComplaint(e.target.value)}
                    required
                ></textarea>

                <button type="submit">
                    Raise Complaint
                </button>

            </form>

        </div>
    );
}

export default ComplaintRegister;