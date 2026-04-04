package task1and2and4;

public class CryptoPayment implements PaymentMethod{

    @Override
    public String name() {
        return "CryptoPayment";
    }

    @Override
    public boolean pay(int amount) {
        return amount % 5 == 0;
    }
}
