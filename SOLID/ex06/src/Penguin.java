public class Penguin extends Bird implements Flyable {
    public Penguin() {
        super("Penguin");
    }

    @Override
    public void fly() {
        System.out.println("Cannot fly - I'm a penguin!");
    }
}
