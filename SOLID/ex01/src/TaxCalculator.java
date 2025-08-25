public class TaxCalculator {
    private final double taxRate;

    public TaxCalculator(double taxRate) {
        this.taxRate = taxRate;
    }

    public double totalWithTax(double subtotal) {
        return subtotal + subtotal * taxRate;
    }
}
