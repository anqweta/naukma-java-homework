package task1;

public interface MediaSource {
    String id();
    String type(); //audio or video
    int sizeMb();
    boolean open();
}


