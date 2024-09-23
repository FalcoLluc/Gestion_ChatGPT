import java.util.List;

public class Manager extends User {
    private List<Project> managedProjects;

    public Manager(String name) {
        super(name, RoleNames.MANAGER);
    }

    public void assignProgrammerToProject(Project project, Programmer programmer) {
        project.addProgrammer(programmer);
        programmer.assignProject(project);
        System.out.println("Programmer '" + programmer.getName() + "' assigned to project '" + project.getName() + "'.");
    }

    public void createTaskInProject(Project project, String taskDescription, Programmer programmer) {
        // Check if the programmer is assigned to the project
        if (!project.getProgrammers().contains(programmer)) {
            System.out.println("Error: Programmer '" + programmer.getName() + "' is not assigned to the project '" + project.getName() + "'. Cannot assign task.");
            return;
        }

        Task task = new Task(taskDescription, programmer);
        project.addTask(task);
        programmer.assignTask(task);
        System.out.println("Task created and assigned to '" + programmer.getName() + "' in project '" + project.getName() + "'.");
    }

    @Override
    public void displayRolePermissions() {
        System.out.println("Manager Permissions: Manage projects and tasks.");
    }
}




