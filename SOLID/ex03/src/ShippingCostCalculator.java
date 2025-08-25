import java.util.HashMap;
import java.util.Map;

public class ShippingCostCalculator {
    private final Map<String, ShippingStrategy> strategies = new HashMap<>();

    public ShippingCostCalculator() {
        strategies.put("STANDARD", new StandardShipping());
        strategies.put("EXPRESS", new ExpressShipping());
        strategies.put("OVERNIGHT", new OvernightShipping());
    }

    public double cost(Shipment shipment) {
        ShippingStrategy strategy = strategies.get(shipment.type);
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown type: " + shipment.type);
        }
        return strategy.calculate(shipment.weightKg);
    }
}
