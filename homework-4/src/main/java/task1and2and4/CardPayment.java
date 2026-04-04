package task1and2and4;

public class CardPayment implements PaymentMethod {

    @Override
    public String name() {
        return "CardPayment";
    }

    @Override
    public boolean pay(int amount) {
        return amount <= 50000;
    }

    public void refund(int amount) {
        System.out.println("Поверненно суму: " + amount);
    }

}
