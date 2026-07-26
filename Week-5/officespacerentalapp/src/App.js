import officeImage from "./office.jpg";
import "./App.css";

function App() {

    const office = {
        name: "Skyline Business Center",
        rent: 55000,
        address: "T. Nagar, Chennai"
    };

    const offices = [
        {
            name: "Skyline Business Center",
            rent: 55000,
            address: "T. Nagar, Chennai"
        },
        {
            name: "Tech Park",
            rent: 75000,
            address: "Guindy, Chennai"
        },
        {
            name: "Infinity Tower",
            rent: 62000,
            address: "OMR, Chennai"
        }
    ];

    return (

        <div className="App">

            <h1>Office Space Rental App</h1>

            <img
                src={officeImage}
                alt="Office Space"
                width="500"
            />

            <hr />

            <h2>Single Office</h2>

            <h3>Name : {office.name}</h3>

            <h3
                style={{
                    color: office.rent < 60000 ? "red" : "green"
                }}
            >
                Rent : ₹ {office.rent}
            </h3>

            <h3>Address : {office.address}</h3>

            <hr />

            <h2>Available Office Spaces</h2>

            {
                offices.map((item, index) => (

                    <div key={index} className="card">

                        <h3>{item.name}</h3>

                        <p
                            style={{
                                color:
                                    item.rent < 60000
                                        ? "red"
                                        : "green"
                            }}
                        >
                            Rent : ₹ {item.rent}
                        </p>

                        <p>{item.address}</p>

                    </div>

                ))
            }

        </div>

    );
}

export default App;