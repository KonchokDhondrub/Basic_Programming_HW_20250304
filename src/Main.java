import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Programmer> programmers = new ProgrammerAndTaskList().getProgrammersAndTasks();

        String reqCity = "Berlin";
        String reqNotStatus = "done";
        int reqMinDays = 5;
        List<Programmer> filtered = requestUndoneTasksFromCityAndDaysLimit(programmers, reqCity, reqNotStatus, reqMinDays);

        print(filtered);

    }

    public static List<Programmer> requestUndoneTasksFromCityAndDaysLimit(
            List<Programmer> programmers, String city, String statusNot, int minDays) {
        List<Programmer> result = new ArrayList<>();
        programmers.stream()
                .filter(p -> p.getCity().equals(city))
                .forEach(p -> {
                    List<Task> filteredTasks = p.getTasks().stream()
                            .filter(task -> task.getDaysInProcessing() > minDays)
                            .filter(task -> !task.getStatus().equals(statusNot))
                            .collect(Collectors.toList());

                    if (!filteredTasks.isEmpty()) {
                        result.add(new Programmer(p.getName(), p.getCity(), filteredTasks));
                    }
                });
        return result;
    }

    public static <E> void print(Collection<E> list){
        list.forEach(a -> System.out.println(a));
    }

}