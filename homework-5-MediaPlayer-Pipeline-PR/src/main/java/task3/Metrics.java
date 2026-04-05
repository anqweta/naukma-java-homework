package task3;

import task1.MediaSource;

public interface Metrics {

    void record(String event);
    default void recordError(String message) {
        System.out.println("ПОМИЛКА! " + message);
    }
    static boolean isValidEvent(String event) {
        return event != null;
    }
}
