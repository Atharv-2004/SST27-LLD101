public class Demo08 {
    public static void main(String[] args) {
        Pedalable bike = new Bicycle();
        bike.pedal(5); // works now safely

        EnginePowered car = new Car();
        car.startEngine(); // works

        ElectricVehicle ev = new Car();
        ev.recharge(50); // works
    }
}
