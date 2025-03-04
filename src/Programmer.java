import java.util.List;
import java.util.Objects;

public class Programmer {
    private final String name;
    private final String city;
    private List<Task> tasks;

    public Programmer(String name, String city, List<Task> tasks) {
        this.name = name;
        this.city = city;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Programmer that = (Programmer) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getTasks(), that.getTasks());
    }
    @Override
    public int hashCode() {
        int result = Objects.hashCode(getName());
        result = 31 * result + Objects.hashCode(getCity());
        result = 31 * result + Objects.hashCode(getTasks());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder tasksFormatted = new StringBuilder();
        for (Task task : tasks) {
            tasksFormatted.append(task.toString());
        }

        return String.format("%-14s [%s]  Tasks:\n%s", name, city, tasksFormatted);
    }
}
