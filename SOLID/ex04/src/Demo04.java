public class Demo04 {
    public static void main(String[] args) {
        Payment payment = new Payment("UPI", 499);
        PaymentService service = new PaymentService();

        service.registerStrategy("CARD", new CardPayment());
        service.registerStrategy("UPI", new UpiPayment());
        service.registerStrategy("WALLET", new WalletPayment());

        System.out.println(service.pay(payment));
    }
}
