import java.util.Comparator;
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

    private StringBuilder taskListOutputFilter(List<Task> list) {
        StringBuilder tasksFormatted = new StringBuilder();

        if (list != null) {
            String separator = list.size() > 1 ? "\n" : "";

            for (int i = 0; i < list.size(); i++) {
                tasksFormatted.append(list.get(i).toString());
                if (i < list.size() - 1) {
                    tasksFormatted.append(separator);
                }
            }
        }
        return tasksFormatted;
    }

    @Override
    public String toString() {
        return String.format("%-14s [%s]  Tasks:\n%s", name, city, (tasks == null) ? "\tNo Tasks" : taskListOutputFilter(tasks));
    }
}
