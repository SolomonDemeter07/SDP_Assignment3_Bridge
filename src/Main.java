public class Main {
    public static void main(String[] args) {
        int passedCount = 0;
        int totalChecks = 7;

        Formatter textFmt = new TextFormatter();
        Formatter htmlFmt = new HtmlFormatter();
        Formatter mdFmt = new MarkdownFormatter();

        Report a1_t1 = new AttendanceReport("R-ATT-01", textFmt, 3, 4);
        String resT1 = a1_t1.execute();
        String expT1 = "--- Attendance Report ---\nAttended: 3 out of 4 (75%)\n-------------------";
        if (resT1.equals(expT1)) {
            System.out.println("T1 PASS | AttendanceReport + TextFormatter | result=\n" + resT1);
            passedCount++;
        } else {
            System.out.println("T1 FAIL | Expected:\n" + expT1 + "\nGot:\n" + resT1);
        }

        Report a1_t2 = new AttendanceReport("R-ATT-02", htmlFmt, 3, 4);
        String resT2 = a1_t2.execute();
        String expT2 = "<h1>Attendance Report</h1>\n<p>Attended: 3 out of 4 (75%)</p>";
        if (resT2.equals(expT2)) {
            System.out.println("T2 PASS | AttendanceReport + HtmlFormatter | result=\n" + resT2);
            passedCount++;
        } else {
            System.out.println("T2 FAIL | Expected:\n" + expT2 + "\nGot:\n" + resT2);
        }


        Report a2_t3 = new GradeReport("R-GRD-01", textFmt, new int[]{70, 80, 90});
        String resT3 = a2_t3.execute();
        String expT3 = "--- Grade Report ---\nAverage Grade: 80\n-------------------";
        if (resT3.equals(expT3)) {
            System.out.println("T3 PASS | GradeReport + TextFormatter | result=\n" + resT3);
            passedCount++;
        } else {
            System.out.println("T3 FAIL | Expected:\n" + expT3 + "\nGot:\n" + resT3);
        }


        Report a2_t4 = new GradeReport("R-GRD-02", htmlFmt, new int[]{70, 80, 90});
        String resT4 = a2_t4.execute();
        String expT4 = "<h1>Grade Report</h1>\n<p>Average Grade: 80</p>";
        if (resT4.equals(expT4)) {
            System.out.println("T4 PASS | GradeReport + HtmlFormatter | result=\n" + resT4);
            passedCount++;
        } else {
            System.out.println("T4 FAIL | Expected:\n" + expT4 + "\nGot:\n" + resT4);
        }


        Report a1_t5 = new AttendanceReport("R-ATT-SWITCH", textFmt, 3, 4);
        Report originalRef = a1_t5;
        String before = a1_t5.execute();

        a1_t5.setImplementation(htmlFmt);
        String after = a1_t5.execute();

        boolean sameObject = (a1_t5 == originalRef);
        boolean stateUnchanged = a1_t5.id.equals("R-ATT-SWITCH");

        if (sameObject && stateUnchanged && !before.equals(after) && after.equals(expT2)) {
            System.out.println("T5 PASS | sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged);
            System.out.println("before=" + before.replace("\n", " ") + " | after=" + after.replace("\n", " "));
            passedCount++;
        } else {
            System.out.println("T5 FAIL");
        }

        System.out.println("SUMMARY: " + passedCount + "/" + totalChecks + " PASS");



        Report a1_t6 = new AttendanceReport("R-ATT-03", mdFmt, 3, 4);
        String resT6 = a1_t6.execute();
        String expT6 = "## Attendance Report\n**Attended: 3 out of 4 (75%)**";
        if (resT6.equals(expT6)) {
            System.out.println("T6 PASS | AttendanceReport + MarkdownFormatter | result=\n" + resT6);
            passedCount++;
        } else {
            System.out.println("T6 FAIL | Expected:\n" + expT6 + "\nGot:\n" + resT6);
        }


        Report a2_t7 = new GradeReport("R-GRD-03", mdFmt, new int[]{70, 80, 90});
        String resT7 = a2_t7.execute();
        String expT7 = "## Grade Report\n**Average Grade: 80**";
        if (resT7.equals(expT7)) {
            System.out.println("T7 PASS | GradeReport + MarkdownFormatter | result=\n" + resT7);
            passedCount++;
        } else {
            System.out.println("T7 FAIL | Expected:\n" + expT7 + "\nGot:\n" + resT7);
        }

        System.out.println("SUMMARY: " + passedCount + "/" + totalChecks + " PASS");

    }
}