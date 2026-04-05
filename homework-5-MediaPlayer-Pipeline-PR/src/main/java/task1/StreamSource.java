package task1;

public class StreamSource implements MediaSource {

    private final String fileName;
    public String type;
    public int sizeMb;

    public StreamSource(String fileName,  String type, int sizeMb) {
        this.fileName = fileName;
        this.type = type;
        this.sizeMb = sizeMb;
    }

    @Override
    public String id() {
        return fileName;
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public int sizeMb() {
        return sizeMb;
    }

    @Override
    public boolean open() {
        if(sizeMb <= 300) {
            System.out.println(type + "-файл " + fileName + " розміром " + sizeMb + " MB запустився");
            return true;
        } else {
            throw new RuntimeException("Помилка: " + type + "-файл не запустився");
        }
    }
}
