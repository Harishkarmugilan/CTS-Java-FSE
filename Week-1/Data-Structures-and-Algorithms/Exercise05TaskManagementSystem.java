class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
}

public class Exercise05TaskManagementSystem {

    static Task head = null;

    static void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
    }

    static void searchTask(int id) {
        Task temp = head;

        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println("Found: " + temp.taskName);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Task Not Found");
    }

    static void traverseTasks() {
        Task temp = head;

        while (temp != null) {
            System.out.println(temp.taskId + " " + temp.taskName + " " + temp.status);
            temp = temp.next;
        }
    }

    static void deleteTask(int id) {
        if (head == null)
            return;

        if (head.taskId == id) {
            head = head.next;
            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args) {

        addTask(101, "Design", "Pending");
        addTask(102, "Coding", "In Progress");
        addTask(103, "Testing", "Pending");

        System.out.println("Tasks:");
        traverseTasks();

        searchTask(102);

        deleteTask(102);

        System.out.println("\nAfter Deletion:");
        traverseTasks();
    }
}