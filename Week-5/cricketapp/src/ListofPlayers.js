function ListofPlayers() {

    const players = [
        { name: "Virat Kohli", score: 95 },
        { name: "Rohit Sharma", score: 88 },
        { name: "Shubman Gill", score: 78 },
        { name: "KL Rahul", score: 65 },
        { name: "Rishabh Pant", score: 55 },
        { name: "Hardik Pandya", score: 72 },
        { name: "Ravindra Jadeja", score: 69 },
        { name: "R Ashwin", score: 81 },
        { name: "Jasprit Bumrah", score: 91 },
        { name: "Mohammed Shami", score: 60 },
        { name: "Mohammed Siraj", score: 74 }
    ];

    const lowScorePlayers = players.filter(
        player => player.score < 70
    );

    return (
        <div>

            <h2>List of Players</h2>

            {players.map((player, index) => (
                <p key={index}>
                    {player.name} - {player.score}
                </p>
            ))}

            <hr />

            <h2>Players with Score Below 70</h2>

            {lowScorePlayers.map((player, index) => (
                <p key={index}>
                    {player.name} - {player.score}
                </p>
            ))}

        </div>
    );
}

export default ListofPlayers;