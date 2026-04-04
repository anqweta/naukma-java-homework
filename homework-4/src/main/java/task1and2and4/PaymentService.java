package task1and2and4;

import java.util.logging.Logger;

public class PaymentService {

    private static final Logger logger = Logger.getLogger(PaymentService.class.getName());

    boolean process(PaymentMethod method, int amount) {
        logger.info("Processing " + method.name() + " with amount " + amount);
        boolean result = method.pay(amount);
        if (result) {
            logger.info("Payment successful");
        } else {
            logger.info("Payment failed");
        }
        return result;
    }

    boolean process(int amount, PaymentMethod... methods) {
        for (PaymentMethod method : methods) {
            logger.info("Processing " + method.name() + " with amount " + amount);
            boolean result = method.pay(amount);
            if (result) {
                logger.info("Payment successful with method " + method.name());
                return  true;
            }
        }
        logger.info("Payment failed");
        return false;
    }

}
