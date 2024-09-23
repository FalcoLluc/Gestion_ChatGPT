import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private Manager manager;
    private List<Programmer> programmers;
    private List<Task> tasks;

    public Project(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
        this.programmers = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Set or change the manager
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    // Add a programmer to the project
    public void addProgrammer(Programmer programmer) {
        programmers.add(programmer);
    }

    // Add a task to the project
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Get the list of tasks
    public List<Task> getTasks() {
        return tasks;
    }

    // List all programmers on the project
    public void listProgrammers() {
        for (Programmer programmer : programmers) {
            System.out.println(programmer.getName());
        }
    }

    // List all tasks in the project
    public void listTasks() {
        for (Task task : tasks) {
            System.out.println(task.getDescription() + " (Completed: " + task.isCompleted() + ")");
        }
    }
}



