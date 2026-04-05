package task2;

import task1.MediaSource;

public abstract class PlaybackPipeline {

    MediaSource source;

    public final void play(MediaSource source) {
        validate(source);
        decode(source);
        render(source);
        finish(source);
    }

    protected abstract void validate(MediaSource source);
    protected abstract void decode(MediaSource source);

    protected void render(MediaSource source) {
        System.out.println("Рендер програми");
    }

    protected void finish(MediaSource source) {
        System.out.println("Закінчення програвання");
    }

}
