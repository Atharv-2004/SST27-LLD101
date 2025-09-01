import com.example.orders.*;

public class TryIt {
    public static void main(String[] args) {
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);

        Order o = new Order.Builder("o2", "a@b.com")
                .addLine(l1)
                .addLine(l2)
                .discountPercent(10)
                .build();

        System.out.println("Before: " + o.totalAfterDiscount());

        try {
            o.getLines().add(new OrderLine("C", 1, 150));
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify order lines - they are immutable!");
        }

        System.out.println("After:  " + o.totalAfterDiscount());
        System.out.println("=> In the solution, totals remain stable due to defensive copies.");

        try {
            new Order.Builder("", "invalid-email")
                    .addLine(l1)
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation caught: " + e.getMessage());
        }
    }
}
