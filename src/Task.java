public class Task {
    private String description;
    private boolean completed;
    private Programmer programmer;

    public Task(String description, Programmer programmer) {
        this.description = description;
        this.completed = false;
        this.programmer = programmer;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Programmer getProgrammer() {
        return programmer;
    }

    public void setProgrammer(Programmer programmer) {
        this.programmer = programmer;
    }
}



