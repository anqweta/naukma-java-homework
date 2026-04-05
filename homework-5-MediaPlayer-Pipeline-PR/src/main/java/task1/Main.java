package task1;

import task2.PlaybackPipeline;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        MediaSource mediaSource = new LocalFileSource("file1", "video", 1100);
        MediaSource mediaSource2 = new StreamSource("file2", "audio", 30);
        MediaSource mediaSource3 = new UsbSource("file3", "video", 700);

        mediaSource2.open();
        mediaSource3.open();
        mediaSource.open();

        MediaSource[] playlist = {
                mediaSource,
                mediaSource2,
                mediaSource3,
        };

        for (MediaSource media : playlist) {
            media.open();
        }
    }
}
