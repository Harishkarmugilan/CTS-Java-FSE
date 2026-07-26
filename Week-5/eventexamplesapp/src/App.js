import logo from './logo.svg';
import './App.css';
import {useState} from 'react';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  const [count, setCount] = useState(0);

  function incrementCount() {
    setCount(count + 1);
    alert("Hello! Member 1")
  }
  function decrementCount() {
    setCount(count - 1);
    alert("Decremented 1")
  }

  return (
<div className="App">
  <div className="Count">{count}</div>
  <div className="Buttons">
    <button onClick={incrementCount}>Increment 1</button>
    <button onClick={decrementCount}>Decrement 1</button>
    <button onClick={() => alert("Welcome !")}>Say Welcome</button>
    <button onClick={() => alert("I was clicked!")}>Click Me !</button>
  </div>

  <CurrencyConvertor />
  </div>
  );
}

export default App;
