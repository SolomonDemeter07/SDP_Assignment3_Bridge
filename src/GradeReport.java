public class GradeReport extends Report {
    private int[] grades;

    public GradeReport(String id, Formatter formatter, int[] grades) {
        super(id, formatter);
        this.grades = grades;
    }

    @Override
    public String execute() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        int average = sum / grades.length;
        String content = "Average Grade: " + average;

        return formatter.format("Grade Report", content);
    }
}