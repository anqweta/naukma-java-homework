package task2;

import task1.LocalFileSource;
import task1.MediaSource;
import task1.StreamSource;
import task1.UsbSource;

public class Main {
    public static void main(String[] args) {
        MediaSource mediaSource = new LocalFileSource("file1", "аудіо", 1100);
        MediaSource mediaSource2 = new StreamSource("file2", "аудіо", 30);
        MediaSource mediaSource3 = new UsbSource("file3", "аудіо", 700);
        MediaSource[] playlist = {
                mediaSource,
                mediaSource2,
                mediaSource3,
        };

        PlaybackPipeline audioPlayer = new AudioPipeline();
        PlaybackPipeline videoPlayer = new VideoPipeline();

        for (MediaSource source : playlist) {
            try {
                audioPlayer.play(source);
                System.out.println("===========");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("===========");
            }
        }
    }
}
