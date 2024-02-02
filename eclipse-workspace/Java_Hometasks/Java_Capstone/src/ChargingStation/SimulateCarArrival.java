package ChargingStation;

import java.util.Scanner;

import Exceptions.InputNotValidException;
import Management.LogManager;

public class SimulateCarArrival {
	private static final Scanner scanner = new Scanner(System.in);
	
    public static void simulateCarArrival(ChargingStations selectedStation) throws Exception {
        ChargingStations station = selectedStation;
        System.out.println("\nSelected charging station: " + station.nameOfChargingStation);
        //systemLogger.log(Level.INFO, "Selected charging station: " + station.nameOfChargingStation);

        // Charging Process based on Vehicle Type
        System.out.print("\nIs the vehicle electric? (yes/no): ");
        String isElectric = scanner.next().toLowerCase();

        try {
            if (!isElectric.equals("yes") && !isElectric.equals("no")) {
                throw new InputNotValidException("Please enter either 'yes' or 'no'");
            }
        } catch (InputNotValidException e) {
            System.out.println(e.getMessage());
        }


        if (isElectric.equals("yes")) {
            // Charging Process for Electric Vehicles
            System.out.println("The energy sources available to charge batteries are: Solar, Wind and Hydro");
            String elecEnergy = null;

            // Simulate weather conditions for electric vehicles
            System.out.print("Enter the weather condition (Sunny, Windy, Rainy): ");
            String weatherCondition = scanner.next().toLowerCase();

            switch (weatherCondition) {
                case "sunny":
                    elecEnergy = "Solar Energy";
                    System.out.println("The battery(s) will be charged using Solar energy.");
                    break;
                case "windy":
                    elecEnergy = "Wind Energy";
                    System.out.println("The battery(s) will be charged using Wind energy.");
                    break;
                case "rainy":
                    elecEnergy = "Hydro Energy";
                    System.out.println("The battery(s) will be charged using Hydro energy.");
                    break;
                default:
                    System.out.println("Invalid weather condition.");
                    //systemLogger.log(Level.WARNING, "Invalid weather condition.");
            }

            //systemLogger.log(Level.INFO, "Simulated weather condition for electric vehicle: " + weatherCondition);
            System.out.println("Simulated weather condition for electric vehicle: " + weatherCondition);
            System.out.println("You have 3 free charging slots available for charging with " + elecEnergy);
            
            LogManager.chargingStationsLogDetails(station, elecEnergy);

            try {
                ChargeBatteries.chargeBatteries(station, elecEnergy);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
               // systemLogger.log(Level.SEVERE, "Charging error", e);
            }

        } else {
            
        }
    }

}
