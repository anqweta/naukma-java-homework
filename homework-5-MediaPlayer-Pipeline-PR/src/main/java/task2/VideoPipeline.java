package task2;

import task1.MediaSource;

public class VideoPipeline extends PlaybackPipeline {
    @Override
    protected void validate(MediaSource source) {

        if (!"аудіо".equals(source.type())) {
        throw new RuntimeException("Помилка! Це не відео файл");
    }
        if (!source.open()) {
            throw  new RuntimeException("Помилка! Файл не відкрився!");
        }
        System.out.println("Валідація успішна");
    }

    @Override
    protected void decode(MediaSource source) {
        System.out.println("Декодування відео " + source.id());
    }
}
