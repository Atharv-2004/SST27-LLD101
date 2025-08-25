import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    private final Map<String, PaymentStrategy> strategies = new HashMap<>();

    public void registerStrategy(String provider, PaymentStrategy strategy) {
        strategies.put(provider, strategy);
    }

    public String pay(Payment payment) {
        PaymentStrategy strategy = strategies.get(payment.provider);
        if (strategy == null) {
            throw new RuntimeException("No provider");
        }
        return strategy.pay(payment.amount);
    }
}
