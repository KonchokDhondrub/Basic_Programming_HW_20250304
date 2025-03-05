import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task {
    private int number;
    private String description;
    private String status;
    private int daysInProcessing;

    public Task(int number, String description, String status, int daysInProcessing) {
        this.number = number;
        this.description = description;
        this.status = status;
        this.daysInProcessing = daysInProcessing;
    }

    public Task(String description, String status, int daysInProcessing) {
        this.number = number;
        this.description = description;
        this.status = status;
        this.daysInProcessing = daysInProcessing;
    }

    public int getNumber() {
        return number;
    }
    public String getDescription() {
        return description;
    }
    public String getStatus() {
        return status;
    }
    public int getDaysInProcessing() {
        return daysInProcessing;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;
        return getNumber() == task.getNumber();
    }
    @Override
    public int hashCode() {
        return getNumber();
    }

    @Override
    public String toString() {
        StringBuilder statusf = new StringBuilder();
        statusf.append(status.toUpperCase().charAt(0))
                .append(status.substring(1));

        return String.format(((number!=0) ? "\t%2d) " : "%s") + "%-26s Status: %-14s Days in process: %d",
                ((number!=0) ? number : ""), description, statusf, daysInProcessing);
    }
}
