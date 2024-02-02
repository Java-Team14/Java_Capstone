package ChargingStation;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnergySource {
	private static final Logger systemLogger = Logger.getLogger("System");
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static String selectEnergySource(ChargingStations chargingStation) throws Exception {
        System.out.println("Available energy sources for " + chargingStation.nameOfChargingStation + ": "
                + chargingStation.availableSourceOfEnergy);
        System.out.print("Enter your choice: ");
        String userInput = scanner.next();
        if (!chargingStation.availableSourceOfEnergy.contains(userInput)) {
            systemLogger.log(Level.WARNING, "Invalid energy source selected: " + userInput);
        }
        return userInput;
    }
}
