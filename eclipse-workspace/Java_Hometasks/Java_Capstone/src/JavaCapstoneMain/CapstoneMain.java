package JavaCapstoneMain;

import java.util.Scanner;

import ChargingStation.ChargingStations;
import ChargingStation.SimulateCarArrival;
import Management.EnergyManagementSystem;
import ChargingStation.ChargingStationFinder;

public class CapstoneMain {
    //private static final Logger systemLogger = Logger.getLogger("System");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        
        ChargingStations Ionity = new ChargingStations("Ionity", 4, "Diesel", "Petrol");
        ChargingStations FastEnd = new ChargingStations("FastEnd", 6, "Diesel", "CNG");
        ChargingStations Ladestation = new ChargingStations("Ladestation", 7, "CNG", "Petrol");
        ChargingStations Vattenfall = new ChargingStations("Vattenfall", 8, "Diesel", "Petrol", "CNG");
        
        ChargingStations csarray[] = {Ionity, FastEnd, Ladestation, Vattenfall};

        System.out.println("Welcome to the Car Charging Simulator !\n");
        
        ChargingStationFinder.chargingStationFinder(csarray);
        
        // Simulate multiple cars arriving at different stations
        for (int i = 0; i < csarray.length; i++) {
            SimulateCarArrival.simulateCarArrival(csarray[i]);
        }

        

        // Closing scanner to prevent resource leak
        scanner.close();
    }

}
