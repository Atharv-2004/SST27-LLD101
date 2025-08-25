public class OrderService {
    private final Notifier notifier;
    private final TaxCalculator taxCalculator;
    private final OrderRepository repository;

    public OrderService(Notifier notifier, TaxCalculator taxCalculator, OrderRepository repository) {
        this.notifier = notifier;
        this.taxCalculator = taxCalculator;
        this.repository = repository;
    }

    public void checkout(String customerEmail, double subtotal) {
        double total = taxCalculator.totalWithTax(subtotal);
        notifier.send(customerEmail, "Thanks! Your total is " + total);
        repository.save(total);
    }
}
