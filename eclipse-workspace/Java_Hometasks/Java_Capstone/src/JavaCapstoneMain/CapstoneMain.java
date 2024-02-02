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
        // Management system for energy sources
        System.out.println("\nDo you wish to have additional energy resources in the future? (yes/no)");
        String isYes = scanner.next().toLowerCase();

        if (isYes.equals("yes")) {
            System.out.println("Please provide your input");
            String chosenSource = scanner.next();
            EnergyManagementSystem.addEnergySource(chosenSource);
            System.out.println("Thank you for your input. Have a good day!");
            EnergyManagementSystem.displayAvailableEnergySources();
        } else {
            System.out.println("Thank you. Have a good day!");
            EnergyManagementSystem.displayAvailableEnergySources();
        }
        // Closing scanner to prevent resource leak
        scanner.close();
    }

}
