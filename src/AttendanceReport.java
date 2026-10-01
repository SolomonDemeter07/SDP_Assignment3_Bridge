public class AttendanceReport extends Report {
    private int attendedSessions;
    private int totalSessions;

    public AttendanceReport(String id, Formatter formatter, int attendedSessions, int totalSessions) {
        super(id, formatter);
        this.attendedSessions = attendedSessions;
        this.totalSessions = totalSessions;
    }

    @Override
    public String execute() {
        int percentage = (int) Math.round((double) attendedSessions / totalSessions * 100);
        String content = "Attended: " + attendedSessions + " out of " + totalSessions + " (" + percentage + "%)";

        return formatter.format("Attendance Report", content);
    }
}