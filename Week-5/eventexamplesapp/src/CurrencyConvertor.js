import react from 'react';

function CurrencyConvertor() {
    const [amount, setAmount] = react.useState(0);
    const [currency, setCurrency] = react.useState('USD');

    const currencies = {
        USD: 100,
        EUR: 85,
        GBP: 73
    }

    function handleAmountChange(props) {
        alert("The converted amount is: " + amount / currencies[currency] + " " + currency  );


    }

    return (
        <div>
            <h1>Currency Convertor</h1>
            <div className="currency-convertor">
                <table>
                    <tr>
                        <td>
                            <label>Amount in rupees:</label>
                        </td>
                        <td><input type="number" placeholder="Enter amount" value={amount} onChange={(e) => setAmount(parseFloat(e.target.value))} /></td>
                    </tr>
                    <tr>
                        <td>
                            <label>Currency:</label>
                        </td>
                        <td><select value={currency} onChange={(e) => setCurrency(e.target.value)}>
                            {Object.keys(currencies).map((currency) => (
                                <option key={currency} value={currency}>{currency}</option>
                            ))}
                        </select></td>
                    </tr>
<tr><td colSpan="2" align='center'><button onClick={handleAmountChange}>Convert</button></td></tr>

                    
                </table>
            </div>
        </div>
    );


}

export default CurrencyConvertor;