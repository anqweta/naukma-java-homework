package task4;

import java.util.List;
import java.util.Optional;

public class UserRepository {

    private static final List<User> users = List.of(
            new User("Аня", "anya@example.com"),
            new User("Іван", "ivan@test.com"),
            new User("Марія", "maria@domain.ua")
    );

    static Optional<User> findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }


}
