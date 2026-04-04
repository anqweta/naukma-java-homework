package task1and2and4;

public class Main {
    static void main() {
        CardPayment cardPayment = new CardPayment();
        CryptoPayment cryptoPayment = new CryptoPayment();
        PayPalPayment payPalPayment = new PayPalPayment();
        PaymentService service = new PaymentService();

        System.out.println(service.process(cardPayment, 100));
        System.out.println(service.process(100, cardPayment, payPalPayment, cryptoPayment));

        PaymentMethod[] paymentMethods = new PaymentMethod[]{
                cardPayment,
                payPalPayment,
                cryptoPayment
        };

        for (PaymentMethod paymentMethod : paymentMethods) {
            if (paymentMethod instanceof CardPayment) {
                cardPayment.refund(100);
            }
        }

    }
}
