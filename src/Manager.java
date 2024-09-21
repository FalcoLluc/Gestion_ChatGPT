import java.util.ArrayList;
import java.util.List;

public class Manager extends User {
    private List<Project> managedProjects;

    public Manager(String name) {
        super(name, RoleNames.MANAGER);
        this.managedProjects = new ArrayList<>();
    }

    // Create a new project and assign it to this manager
    public void createProject(String projectName) {
        Project project = new Project(projectName, this);
        managedProjects.add(project);
        System.out.println("Project created: " + projectName);
    }

    // List all managed projects
    public void listProjects() {
        for (Project project : managedProjects) {
            System.out.println(project.getName());
        }
    }

    // Find a project by name
    public Project findProjectByName(String projectName) {
        for (Project project : managedProjects) {
            if (project.getName().equalsIgnoreCase(projectName)) {
                return project;
            }
        }
        return null; // Return null if not found
    }

    // Assign a programmer to a project
    public void assignProgrammerToProject(Project project, Programmer programmer) {
        project.addProgrammer(programmer);
        programmer.assignProject(project);
        System.out.println("Programmer " + programmer.getName() + " assigned to project " + project.getName());
    }

    // Create a task in a project and assign it to a programmer
    public void createTaskInProject(Project project, String taskDescription, Programmer programmer) {
        Task task = new Task(taskDescription, programmer);
        project.addTask(task);
        programmer.assignTask(task);
        System.out.println("Task created and assigned to " + programmer.getName());
    }

    @Override
    public void displayRolePermissions() {
        System.out.println("Manager Permissions: Create projects, assign programmers, manage tasks.");
    }
}



