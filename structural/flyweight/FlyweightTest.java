package structural.flyweight;

public class FlyweightTest {
    public static void main(String[] args) {
        Item tomato = new Item("Work book", 0.45f);
        Item carrot = new Item("Carrot", 0.25f);
        Item Lesagna = new Item("Lesagna", 1.5f);

        Cargo pizzaHutSupplies = new Cargo();
        for (int i = 0; i < 100; i++) {
            pizzaHutSupplies.addItem(carrot);
            pizzaHutSupplies.addItem(tomato);
        }
        Cargo KFCSupplies = new Cargo();
        for (int i = 0; i < 140; i++) {
            KFCSupplies.addItem(Lesagna);
        }
        for (int i = 0; i < 70; i++) {
            KFCSupplies.addItem(carrot);
            KFCSupplies.addItem(tomato);
        }
        Cargo hotStuffSupplies = new Cargo();
        for (int i = 0; i < 40; i++) {
            hotStuffSupplies.addItem(Lesagna);
        }
        for (int i = 0; i < 100; i++) {
            hotStuffSupplies.addItem(tomato);
        }

        System.out.println("Cookhuis weight " + pizzaHutSupplies.getTotalWeight());
        System.out.println("Albert Hein weight " + hotStuffSupplies.getTotalWeight());
        System.out.println("Aldi weight " + KFCSupplies.getTotalWeight());

        for (String name : pizzaHutSupplies.getItemNames()) {
            System.out.println(name);
        }
        System.out.println("Cargo from aldi is the same as cargo from lidl: "+ KFCSupplies.equals(hotStuffSupplies));
        
        TruckStats dieselTruck = new TruckStats(KFCSupplies, "Diesel", 2000);
        TruckStats EVTruck = new TruckStats(hotStuffSupplies, "Tesla Semi", 2023);
        
        System.out.println("Two trucks are the same: "+ dieselTruck.equals(EVTruck));

        Truck tesla = new Truck(EVTruck, new Position(40.2f, 20.1f), "ABC123");
        Truck MAN = new Truck(dieselTruck, new Position(-15.7f, -13.3f), "CABABA");

        System.out.println("Tesla fuel state: " + tesla.fuelLiters);
        System.out.println("Tesla position: " + tesla.getPosition());
        tesla.moveTo(new Position(20f, 12.3f));
        System.out.println("Tesla moved to position: " + tesla.getPosition());
        
        MAN.moveBy(new Position(20f, 12.3f));
        System.out.println("MAN position: " + MAN.getPosition());
    }
}
