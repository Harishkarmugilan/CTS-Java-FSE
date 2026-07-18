import {
    BrowserRouter,
    Routes,
    Route,
    Link
} from 'react-router-dom';

import Home from './Home';
import TrainersList from './TrainersList';
import TrainerDetails from './TrainerDetails';
import trainers from './TrainersMock';

function App() {

    return (
        <BrowserRouter>

            <div>

                <h1>Trainers App</h1>

                <nav>
                    <Link to="/">Home</Link>
                    {" | "}
                    <Link to="/trainers">Trainers</Link>
                </nav>

                <hr />

                <Routes>

                    <Route
                        path="/"
                        element={<Home />}
                    />

                    <Route
                        path="/trainers"
                        element={<TrainersList trainers={trainers} />}
                    />

                    <Route
                        path="/trainers/:id"
                        element={<TrainerDetails />}
                    />

                </Routes>

            </div>

        </BrowserRouter>
    );
}

export default App;