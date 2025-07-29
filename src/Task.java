public class Task {
    private int id;
    private String description;
    private int estimatedHours;

    public Task(String description, int estimatedHours) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be null or empty.");
        }
        if (estimatedHours <= 0) {
            throw new IllegalArgumentException("Estimated hours must be greater than 0.");
        }
        this.description = description;
        this.estimatedHours = estimatedHours;
    }

    public String getDescription() {
        return description;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    @Override
    public String toString() {
        return "Task: " + description + " | Estimated Hours: " + estimatedHours;
    }
}
