import java.util.ArrayList;
import java.util.List;

public class Programmer extends User {
    private List<Project> assignedProjects;
    private List<Task> assignedTasks;

    public Programmer(String name) {
        super(name, RoleNames.PROGRAMMER);
        this.assignedProjects = new ArrayList<>();
        this.assignedTasks = new ArrayList<>();
    }

    // Assign a project to the programmer
    public void assignProject(Project project) {
        assignedProjects.add(project);
    }

    // List all assigned projects
    public void listAssignedProjects() {
        for (Project project : assignedProjects) {
            System.out.println(project.getName());
        }
    }

    // Assign a task to the programmer
    public void assignTask(Task task) {
        assignedTasks.add(task);
    }

    // List all assigned tasks
    public void listAssignedTasks() {
        for (Task task : assignedTasks) {
            System.out.println(task.getDescription() + " (Completed: " + task.isCompleted() + ")");
        }
    }

    // Find a task by its description
    public Task findTaskByDescription(String description) {
        for (Task task : assignedTasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                return task;
            }
        }
        return null; // Return null if not found
    }

    // Mark a task as completed
    public void markTaskAsCompleted(String description) {
        Task task = findTaskByDescription(description);
        if (task != null) {
            task.setCompleted(true);
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Task not found.");
        }
    }

    @Override
    public void displayRolePermissions() {
        System.out.println("Programmer Permissions: View projects, manage tasks.");
    }
}


