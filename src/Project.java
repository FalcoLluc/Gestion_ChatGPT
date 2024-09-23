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

    public List<Programmer> getProgrammers() {
        return programmers;
    }

    public void addProgrammer(Programmer programmer) {
        programmers.add(programmer);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void listProgrammers() {
        for (Programmer programmer : programmers) {
            System.out.println(programmer.getName());
        }
    }

    public void listTasks() {
        for (Task task : tasks) {
            System.out.println(task.getDescription() + " (Completed: " + task.isCompleted() + ")");
        }
    }
}



