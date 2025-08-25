public class Demo01 {
    public static void main(String[] args) {
        Notifier notifier = new EmailClient(); // abstraction used
        TaxCalculator taxCalculator = new TaxCalculator(0.18);
        OrderRepository repository = new OrderRepository();

        OrderService orderService = new OrderService(notifier, taxCalculator, repository);
        orderService.checkout("a@shop.com", 100.0);
    }
}
