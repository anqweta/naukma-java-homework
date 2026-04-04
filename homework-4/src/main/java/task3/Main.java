package task3;

public class Main {
    public static void main(String[] args) {
        BaseNotifier n = new EmailNotifier();
        n.notifyUser("Hello");
    }
}

//Оскільки об'єкт був створений як new EmailNotifier(), Java використовує динамічне зв'язування (late binding). Вона
// бачить, що метод notifyUser був перевизначений (@Override), і викликає найбільш специфічну
// реалізацію — тобто ту, що в EmailNotifier.