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
        return getNumber() == task.getNumber() && getDaysInProcessing() == task.getDaysInProcessing() && Objects.equals(getDescription(), task.getDescription()) && Objects.equals(getStatus(), task.getStatus());
    }
    @Override
    public int hashCode() {
        int result = getNumber();
        result = 31 * result + Objects.hashCode(getDescription());
        result = 31 * result + Objects.hashCode(getStatus());
        result = 31 * result + getDaysInProcessing();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder statusf = new StringBuilder();
        statusf.append(status.toUpperCase().charAt(0))
                .append(status.substring(1));

        return String.format("\t%2d) %-26s Status: %-14s Days in process: %d", number, description, statusf, daysInProcessing)
                +System.lineSeparator();
    }
}
