public abstract class Report {
    protected String id;
    protected Formatter formatter;

    public Report(String id, Formatter formatter) {
        this.id = id;
        this.formatter = formatter;
    }

    public void setImplementation(Formatter formatter) {
        this.formatter = formatter;
    }

    public abstract String execute();
}