import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Asegúrate de importar Scanner

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
        if (assignedTasks.isEmpty()) {
            System.out.println("No tasks assigned.");
            return;
        }
        for (int i = 0; i < assignedTasks.size(); i++) {
            Task task = assignedTasks.get(i);
            System.out.println((i + 1) + ". " + task.getDescription() + " (Completed: " + task.isCompleted() + ")");
        }
    }

    // Mark a task as completed by selecting its number
    public void markTaskAsCompleted() {
        List<Task> incompleteTasks = new ArrayList<>();

        // Collect only incomplete tasks
        for (Task task : assignedTasks) {
            if (!task.isCompleted()) {
                incompleteTasks.add(task);
            }
        }

        if (incompleteTasks.isEmpty()) {
            System.out.println("No incomplete tasks to mark as completed.");
            return;
        }

        // List incomplete tasks
        System.out.println("Incomplete Tasks:");
        for (int i = 0; i < incompleteTasks.size(); i++) {
            Task task = incompleteTasks.get(i);
            System.out.println((i + 1) + ". " + task.getDescription());
        }

        // User selects task to mark as completed
        System.out.print("Enter the task number to mark as completed: ");

        Scanner scanner = new Scanner(System.in);
        int taskNumber = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        if (taskNumber < 1 || taskNumber > incompleteTasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        Task taskToComplete = incompleteTasks.get(taskNumber - 1);
        taskToComplete.setCompleted(true);
        System.out.println("Task '" + taskToComplete.getDescription() + "' marked as completed.");
    }

    @Override
    public void displayRolePermissions() {
        System.out.println("Programmer Permissions: View projects, manage tasks.");
    }
}





