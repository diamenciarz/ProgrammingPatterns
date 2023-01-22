package structural.flyweight;

public class FlyweightTest {
    public static void main(String[] args) {
        Item book = new Item("Work book", 0.45f);
        Item knife = new Item("Shiv", 0.25f);
        Item yoyo = new Item("Yoyo", 1.5f);

        Cargo cookhuisSupplies = new Cargo();
        for (int i = 0; i < 100; i++) {
            cookhuisSupplies.addItem(knife);
            cookhuisSupplies.addItem(book);
        }
        Cargo aldiSupplies = new Cargo();
        for (int i = 0; i < 140; i++) {
            aldiSupplies.addItem(yoyo);
        }
        for (int i = 0; i < 70; i++) {
            aldiSupplies.addItem(knife);
            aldiSupplies.addItem(book);
        }
        Cargo albertHeinSupplies = new Cargo();
        for (int i = 0; i < 40; i++) {
            albertHeinSupplies.addItem(yoyo);
        }
        for (int i = 0; i < 100; i++) {
            albertHeinSupplies.addItem(book);
        }

        System.out.println("Cookhuis weight " + cookhuisSupplies.getTotalWeight());
        System.out.println("Albert Hein weight " + albertHeinSupplies.getTotalWeight());
        System.out.println("Aldi weight " + aldiSupplies.getTotalWeight());

        for (String name : cookhuisSupplies.getItemNames()) {
            System.out.println(name);
        }
        System.out.println("Cargo from aldi is the same as cargo from lidl: "+ aldiSupplies.equals(albertHeinSupplies));
        
        TruckStats dieselTruck = new TruckStats(aldiSupplies, "Diesel", 2000);
        TruckStats EVTruck = new TruckStats(albertHeinSupplies, "Tesla Semi", 2023);
        
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
