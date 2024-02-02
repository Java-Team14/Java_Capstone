package Management;

import java.util.*;

public class EnergyManagementSystem {
	public static final List<String> availableEnergySources = new ArrayList<>();

    static {
        availableEnergySources.add("Diesel");
        availableEnergySources.add("Petrol");
        availableEnergySources.add("CNG");
        availableEnergySources.add("Solar");
        availableEnergySources.add("Wind");
        availableEnergySources.add("Hydro");
    }

    public static void displayAvailableEnergySources() {
        System.out.println("Available energy sources : " + availableEnergySources);
    }

    public static void addEnergySource(String energySource) {
        availableEnergySources.add(energySource);
        System.out.println(energySource + " will be added to energy sources");
    }

    public static void removeEnergySource(String energySource) {
        if (availableEnergySources.contains(energySource)) {
            availableEnergySources.remove(energySource);
            System.out.println(energySource + " has been removed from the available energy sources.");
        } else {
            System.out.println(energySource + " is not in the available energy sources.");
        }
    }
}
