import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Programmer> programmers = new ProgrammerAndTaskList().getProgrammersAndTasks();

        String reqCity = "Berlin";
        String reqNotStatus = "done";
        int reqMinDays = 5;
        List<Programmer> filtered = requestUndoneTasksFromCityAndDaysLimit(programmers, reqCity, reqNotStatus, reqMinDays);


        List<Task> allTasks = allTasks(programmers);

        print(filtered);

    }

    public static List<Task> allTasks(List<Programmer> programmers) {
        if (programmers == null) return Collections.emptyList();
        return programmers.stream()
                .filter(p -> Objects.nonNull(p) && Objects.nonNull(p.getTasks()))
                .flatMap( p -> p.getTasks().stream()
                        .filter(Objects::nonNull))
                .distinct()
                .sorted(Comparator.comparing(task -> task.getNumber()))
                .toList();
    }

    public static List<Programmer> requestUndoneTasksFromCityAndDaysLimit(
            List<Programmer> programmers, String city, String statusNot, int minDays) {
        if (programmers == null) return Collections.emptyList();
        List<Programmer> result = new ArrayList<>();
        programmers.stream()
                .filter(p -> Objects.nonNull(p) && Objects.nonNull(p.getTasks()))
                .filter(p -> p.getCity().equalsIgnoreCase(city))
                .forEach(p -> {
                    List<Task> filteredTasks = getFilteredTasks(p.getTasks(), statusNot, minDays);

                    if (!filteredTasks.isEmpty()) {
                        result.add(new Programmer(p.getName(), p.getCity(), filteredTasks));
                    }
                });
        return result;
    }

    public static List<Task> getFilteredTasks(List<Task> tasks, String statusNot, int minDays) {
        if (tasks == null) return Collections.emptyList();
        return tasks.stream()
                .filter(Objects::nonNull)
                .filter(task -> task.getDaysInProcessing() > minDays)
                .filter(task -> !task.getStatus().equalsIgnoreCase(statusNot))
                .collect(Collectors.toList());
    }

    public static <E> void print(Collection<E> list){
        list.stream()
                .filter(p -> Objects.nonNull(p))
                .forEach(a -> System.out.println(a));
    }
}