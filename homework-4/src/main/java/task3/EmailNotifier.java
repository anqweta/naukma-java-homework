package task3;

public class EmailNotifier extends BaseNotifier{

    public void notifyUser(String message) {
        System.out.println("На пошту прийшло нове повідомлення: " + message);
    }

}
