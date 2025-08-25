public class WalletPayment implements PaymentStrategy {
    @Override
    public String pay(double amount) {
        return "Wallet debit: " + amount;
    }
}
