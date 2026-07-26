import EmployeeCard from "./EmployeeCard";

function EmployeesList() {

    const employees = [

        {
            id: 1,
            name: "Harish",
            department: "IT"
        },

        {
            id: 2,
            name: "Rahul",
            department: "HR"
        },

        {
            id: 3,
            name: "Ananya",
            department: "Finance"
        }

    ];

    return (

        <div className="employees-list" style={{ display: "flex", justifyContent: "center" }}>

            {
                employees.map(employee => (

                    <EmployeeCard
                        key={employee.id}
                        employee={employee}
                    />

                ))
            }

        </div>

    );

}

export default EmployeesList;