import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgrammerAndTaskList {
    private List<Programmer> programmersAndTasks;

    public ProgrammerAndTaskList() {
        this.programmersAndTasks = new ArrayList<>();

        programmersAndTasks.add(new Programmer("Alice Schmidt", "Berlin", Arrays.asList(
                new Task(1, "Fix bug #123", "in progress", 7),
                new Task(2, "Develop feature X", "done", 6),
                new Task(13, "Improve logging", "in progress", 8)
        )));

        programmersAndTasks.add(new Programmer("Bob Müller", "Berlin", Arrays.asList(
                new Task(3, "Update documentation", "testing", 10),
                new Task(14, "Refactor old code", "done", 7)
        )));

        programmersAndTasks.add(new Programmer("Charlie Becker", "Frankfurt", Arrays.asList(
                new Task(4, "Refactor module Y", "testing", 8),
                new Task(5, "Optimize database queries", "in progress", 12),
                new Task(15, "Enhance security", "review", 9)
        )));

        programmersAndTasks.add(new Programmer("David Wagner", "Berlin", Arrays.asList(
                new Task(6, "Fix UI bug", "done", 9),
                new Task(16, "Implement dark mode", "in progress", 11)
        )));

        programmersAndTasks.add(new Programmer("Emma Fischer", "Frankfurt", Arrays.asList(
                new Task(7, "Integrate API", "review", 6),
                new Task(17, "Optimize server response", "testing", 8)
        )));

        programmersAndTasks.add(new Programmer("Frank Hoffmann", "Berlin", Arrays.asList(
                new Task(8, "Security audit", "done", 15),
                new Task(18, "Fix authentication bug", "testing", 6)
        )));

        programmersAndTasks.add(new Programmer("Grace Lehmann", "Köln", Arrays.asList(
                new Task(9, "Code cleanup", "testing", 7),
                new Task(19, "Update dependencies", "review", 6),
                new Task(18, "Fix authentication bug", "testing", 6)
        )));

        programmersAndTasks.add(new Programmer("Ian Schäfer", "Berlin", Arrays.asList(
                new Task(11, "Improve performance", "done", 8),
                new Task(21, "Add caching mechanism", "review", 3)
        )));

        programmersAndTasks.add(new Programmer("Jack Neumann", "Berlin", Arrays.asList(
                new Task(12, "Setup CI/CD", "done", 14),
                new Task(22, "Automate deployment", "review", 12)
        )));

        programmersAndTasks.add(new Programmer("James Blacker", "Berlin", null));

        programmersAndTasks.add(null);
    }

    public List<Programmer> getProgrammersAndTasks() {
        return programmersAndTasks;
    }
}
