import Trainer from './Trainer';

const trainers = [
    new Trainer(
        1,
        "John",
        "john@gmail.com",
        "9876543210",
        "Java",
        ["Java", "Spring Boot", "MySQL"]
    ),

    new Trainer(
        2,
        "Peter",
        "peter@gmail.com",
        "9876543211",
        ".NET",
        ["C#", "ASP.NET", "SQL Server"]
    ),

    new Trainer(
        3,
        "David",
        "david@gmail.com",
        "9876543212",
        "React",
        ["HTML", "CSS", "JavaScript", "React"]
    )
];

export default trainers;