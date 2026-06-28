class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

public class Exercise04EmployeeManagementSystem {

    static Employee[] employees = new Employee[10];
    static int count = 0;

    static void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count++] = e;
        }
    }

    static Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    static void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].employeeId + " " +
                               employees[i].name + " " +
                               employees[i].position + " " +
                               employees[i].salary);
        }
    }

    static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null;
                count--;
                break;
            }
        }
    }

    public static void main(String[] args) {

        addEmployee(new Employee(101, "Harish", "Manager", 60000));
        addEmployee(new Employee(102, "Kumar", "Developer", 50000));
        addEmployee(new Employee(103, "Rahul", "Tester", 45000));

        System.out.println("Employees:");
        traverseEmployees();

        Employee e = searchEmployee(102);
        if (e != null) {
            System.out.println("\nFound: " + e.name);
        }

        deleteEmployee(102);

        System.out.println("\nAfter Deletion:");
        traverseEmployees();
    }
}