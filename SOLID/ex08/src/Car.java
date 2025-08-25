public class Car implements EnginePowered, ElectricVehicle {
    @Override
    public void startEngine() {
        System.out.println("Engine started");
    }

    @Override
    public void recharge(int kWh) {
        System.out.println("Recharged " + kWh + " kWh");
    }
}
