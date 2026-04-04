package task1and2and4;

public class PayPalPayment implements PaymentMethod {
    @Override
    public String name() {
        return "PayPalPayment";
    }

    @Override
    public boolean pay(int amount) {
        return amount > 10;
    }
}
