import { useState } from "react";

function User() {

    const flights = [
        {
            company: "Emirates",
            from: "Chennai",
            to: "Dubai"
        },
        {
            company: "Air India",
            from: "Delhi",
            to: "Mumbai"
        },
        {
            company: "IndiGo",
            from: "Bangalore",
            to: "Hyderabad"
        }
    ];

    const [bookings, setBookings] = useState([]);

    function bookTicket(flight) {

        setBookings([
            ...bookings,
            flight
        ]);

    }

    return (
        <div>

            <h2>Welcome User</h2>

            <table border="1" cellPadding="10" style={{margin:"20px auto"}}>

                <thead>
                    <tr>
                        <th>Flight Company</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Action</th>
                    </tr>
                </thead>

                <tbody>

                    {
                        flights.map((flight,index)=>(

                            <tr key={index}>

                                <td>{flight.company}</td>

                                <td>{flight.from}</td>

                                <td>{flight.to}</td>

                                <td>
                                    <button
                                        onClick={() => bookTicket(flight)}
                                    >
                                        Book Ticket
                                    </button>
                                </td>

                            </tr>

                        ))
                    }

                </tbody>

            </table>

            <hr/>

            {
                bookings.map((flight,index)=>(

                    <div
                        key={index}
                        style={{
                            color:"green",
                            marginBottom:"20px"
                        }}
                    >

                        <b>✔ Ticket Booked Successfully</b>

                        <p>Flight : {flight.company}</p>

                        <p>From : {flight.from}</p>

                        <p>To : {flight.to}</p>

                    </div>

                ))
            }

        </div>
    );

}

export default User;