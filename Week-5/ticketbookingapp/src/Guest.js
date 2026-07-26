function Guest() {
    return (
        <div>

            <h2>Welcome Guest</h2>

            <table border="1" cellPadding="10" style={{ margin: "20px auto" }}>
                <thead>
                    <tr>
                        <th>Flight Company</th>
                        <th>From</th>
                        <th>To</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>Emirates</td>
                        <td>Chennai</td>
                        <td>Dubai</td>
                    </tr>

                    <tr>
                        <td>IndiGo</td>
                        <td>Delhi</td>
                        <td>Mumbai</td>
                    </tr>

                    <tr>
                        <td>Air India</td>
                        <td>Bangalore</td>
                        <td>Singapore</td>
                    </tr>
                </tbody>

            </table>

            <p>Please login to book tickets.</p>

        </div>
    );
}

export default Guest;