package task3;

public class Report extends Document {

    public String title;
    public int pages;

    Report(String title) {
        super("ID");
        this.title = title;
    }

    Report(String title, int pages) {
        this(title);
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id='" + id + '\'' +
                "title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }
}
