import java.sql.*;

public class EmployeeTaskManager {

    public void addEmployee(String name) {
        String sql = "INSERT INTO employee (name) VALUES (?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.executeUpdate();
            System.out.println("Employee '" + name + "' added.");

        } catch (SQLException e) {
            System.out.println("Failed to add employee: " + e.getMessage());
        }
    }

    public void addTask(int employeeId, Task task) {
        String sql = "INSERT INTO task (employee_id, description, estimated_hours) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, employeeId);
            stmt.setString(2, task.getDescription());
            stmt.setInt(3, task.getEstimatedHours());
            stmt.executeUpdate();
            System.out.println("Task added for employee #" + employeeId);

        } catch (SQLException e) {
            System.out.println("Failed to add task: " + e.getMessage());
        }
    }

    public void listTasksForEmployee(int employeeId) {
        String sql = "SELECT id, description, estimated_hours FROM task WHERE employee_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Tasks for employee #" + employeeId + ":");
            while (rs.next()) {
                int id = rs.getInt("id");
                String desc = rs.getString("description");
                int hours = rs.getInt("estimated_hours");
                System.out.println("  Task ID " + id + ": " + desc + " (" + hours + " hrs)");
            }

        } catch (SQLException e) {
            System.out.println("Failed to list tasks: " + e.getMessage());
        }
    }
}
