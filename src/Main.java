public class Main {
    public static void main(String[] args) {
        EmployeeTaskManager manager = new EmployeeTaskManager();

        // Add employees
        manager.addEmployee("Ali Moradi");
        manager.addEmployee("azade rafiee");
        manager.addEmployee("Reza farnam");
        manager.addEmployee("Mina Hashemi");

        // Add valid and invalid tasks
        try {
            Task validTask = new Task("Write documentation", 4);
            manager.addTask(1001, validTask);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }

        try {
            Task invalidTask = new Task("", 2);
            manager.addTask(1001, invalidTask);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }

        try {
            Task invalidTask2 = new Task("Refactor code", 0);
            manager.addTask(1001, invalidTask2);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }

        // Add more tasks
        manager.addTask(1002, new Task("Design logo", 2));
        manager.addTask(1003, new Task("Prepare presentation", 4));

        // List tasks for employee 1001
        manager.listTasksForEmployee(1001);
    }
}
