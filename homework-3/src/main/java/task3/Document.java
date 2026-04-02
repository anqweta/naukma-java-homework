package task3;

public class Document {

    public String id;

    Document(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                '}';
    }
}
