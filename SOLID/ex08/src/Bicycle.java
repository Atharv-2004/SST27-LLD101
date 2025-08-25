public class Bicycle implements Pedalable {
    @Override
    public void pedal(int effort) {
        System.out.println("Pedal effort " + effort);
    }
}
