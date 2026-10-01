public class HtmlFormatter implements Formatter {
    @Override
    public String format(String reportTitle, String reportContent) {
        return "<h1>" + reportTitle + "</h1>\n<p>" + reportContent + "</p>";
    }
}