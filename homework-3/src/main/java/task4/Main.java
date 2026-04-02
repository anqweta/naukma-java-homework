package task4;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<User> maybeUser = UserRepository.findByEmail("test@example.com");

        if (maybeUser.isPresent()) {
            User user = maybeUser.get();
            System.out.println(user);
        }

        User userOrDefault = maybeUser.orElse(new User("Новий", "new@example"));
        System.out.println(userOrDefault);

        User userElse = maybeUser.orElseGet(() -> new User("Новий", "new@example"));
        System.out.println(userElse);

        //orElse зазделегідь робить запасний об'єкт
        //orElseGet спочатку дивиться чи існує об'єкт, який ми шукаємо. Якщо не існує, то робить запасний.

    }
}
