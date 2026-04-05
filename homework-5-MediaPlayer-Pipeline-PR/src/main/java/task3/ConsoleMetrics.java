package task3;

import task1.MediaSource;

public class ConsoleMetrics implements Metrics {

    @Override
    public void record(String event) {
        System.out.println("Запис " + event);
    }
}
