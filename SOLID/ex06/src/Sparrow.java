public class Sparrow extends Bird implements Flyable {
    public Sparrow() {
        super("Sparrow");
    }

    @Override
    public void fly() {
        System.out.println("Flap!");
    }
}
