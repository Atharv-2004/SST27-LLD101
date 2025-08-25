public class UpiPayment implements PaymentStrategy {
    @Override
    public String pay(double amount) {
        return "Paid via UPI: " + amount;
    }
}
