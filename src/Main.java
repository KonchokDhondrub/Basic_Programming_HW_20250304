import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Programmer> programmers = new ProgrammerAndTaskList().getProgrammersAndTasks();
//        print(programmers);

        // Tasks 04.03.2025
        String reqCity = "Berlin";
        String reqNotStatus = "done";
        int reqMinDays = 5;
        List<Programmer> filtered = requestUndoneTasksFromCityAndDaysLimit(programmers, reqCity, reqNotStatus, reqMinDays);
//        print(filtered);

        List<Task> allTasks = allTasks(programmers);
//        print(allTasks);



        // Tasks 05.03.2025
        Map<String, Integer> getProgrammersAndTaskAmount = getProgrammersAndTaskAmount(programmers);
//         printMap(getProgrammersAndTaskAmount.entrySet());

        Map<Integer, Task> getTaskByNumberWithDescription = getTaskByNumberWithDescription(programmers);
//         printMap(getTaskByNumberWithDescription.entrySet());

        Map<String, Integer> getAllTaskInCity = getAllTaskInCity(programmers);
        printMap(getAllTaskInCity.entrySet());

    }

    // Tasks 05.03.2025
    public static Map<String, Integer> getProgrammersAndTaskAmount(List<Programmer> list) {
        return nullValuesRemove(list).stream()
                .collect(Collectors.toMap(Programmer::getName, s -> s.getTasks().size()));
    }

    public static Map<Integer, Task> getTaskByNumberWithDescription(List<Programmer> list) {
        return nullValuesRemove(list).stream()
                .flatMap(p -> p.getTasks().stream())
                .distinct()
                .collect(Collectors.toMap(Task::getNumber,
                        t -> new Task(t.getDescription(), t.getStatus(), t.getDaysInProcessing())));
    }

    public static Map<String, Integer> getAllTaskInCity(List<Programmer> list) {
        return nullValuesRemove(list).stream()
                .collect(Collectors.toMap(p -> p.getCity(),
                        p -> p.getTasks().stream().distinct()
                                .mapToInt(t -> 1).sum(), (a, b) -> a + b
                ));
    }

    public static List<Programmer> nullValuesRemove(List<Programmer> list){
        return list.stream()
                .filter(p -> Objects.nonNull(p) && Objects.nonNull(p.getTasks()))
                .toList();
    }



    // Tasks 04.03.2025
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
            List<Programmer> list, String city, String statusNot, int minDays) {
        List<Programmer> result = new ArrayList<>();
        nullValuesRemove(list).stream()
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

    // Prints
    public static <E> void print(Collection<E> list){
        list.stream()
                .filter(p -> Objects.nonNull(p))
                .forEach(a -> System.out.println(a));
    }
    public static <K, V> void printMap(Collection<Map.Entry<K, V>> list) {
        list.stream()
                .filter(p -> Objects.nonNull(p))
                .forEach(a -> System.out.println(a.getKey() + ": " + a.getValue()));
    }
}