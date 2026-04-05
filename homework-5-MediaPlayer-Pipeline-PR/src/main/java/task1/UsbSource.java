package task1;

public class UsbSource implements MediaSource {

    private final String fileName;
    public String type;
    public int sizeMb;

    public UsbSource(String fileName,  String type, int sizeMb) {
        this.fileName = fileName;
        this.type = type;
        this.sizeMb = sizeMb;
    }

    @Override
    public String id() {
        return "";
    }

    @Override
    public String type() {
        return "";
    }

    @Override
    public int sizeMb() {
        return 0;
    }

    @Override
    public boolean open() {
        if(sizeMb <= 1000) {
            System.out.println(type + "-файл " + fileName + " розміром " + sizeMb + " MB запустився");
            return true;
        } else {
            throw new RuntimeException("Помилка: " + type + "-файл не запустився");
        }
    }
}
