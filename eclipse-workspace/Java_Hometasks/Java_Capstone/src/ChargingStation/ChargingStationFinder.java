package ChargingStation;

public class ChargingStationFinder {
	public static void chargingStationFinder(ChargingStations Chargingstationsarray[]) {
        DisplayMenu();
    }

    public static void DisplayMenu() {
        System.out.println("Car Charging Stations : \n"
                + "1. Ionity\n"
                + "2. FastEnd\n"
                + "3. Ladestation\n"
                + "4. Vattenfall");
    }
}
