public class ExpressShipping implements ShippingStrategy {
    @Override
    public double calculate(double weightKg) {
        return 80 + 8 * weightKg;
    }
}
