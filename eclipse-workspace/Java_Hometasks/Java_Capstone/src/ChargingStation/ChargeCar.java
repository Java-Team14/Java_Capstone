package ChargingStation;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import Management.LogManager;

public class ChargeCar {
	private static final Logger dieselLogger = Logger.getLogger("Diesel");
    private static final Logger petrolLogger = Logger.getLogger("Petrol");
    private static final Logger cngLogger = Logger.getLogger("CNG");
    
	public static void chargeCar(ChargingStations chargingStation, String energySource) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		// Check if there is an available charging slot
        if (chargingStation.numberOfFreeStationsAvailable > 0) {
            // Reserve a charging slot
        	chargingStation.numberOfFreeStationsAvailable--;
            System.out.println("Charging slot reserved. Starting charging process at " + new Date() 
            		+ " for station " + chargingStation.nameOfChargingStation + " with energy source " + energySource);

            Thread.sleep(5000);

            // Release the charging slot
            chargingStation.numberOfFreeStationsAvailable++;
            System.out.println("Charging completed. Please visit again!");
            String logMessage = "Charging completed at " + new Date() + " for station " 
            		+ chargingStation.nameOfChargingStation + " with energy source " + 
            		energySource + ". Charging slot released";
            //chargingStation.stationLogger.log(Level.INFO, logMessage);
            
            
            
            // Information on energy source logs
            if ("Diesel".equals(energySource)) {
                dieselLogger.log(Level.INFO, logMessage);
            } else if ("Petrol".equals(energySource)) {
                petrolLogger.log(Level.INFO, logMessage);
            } else if ("CNG".equals(energySource)) {
                cngLogger.log(Level.INFO, logMessage);
            }
            
            LogManager.chargingStationsLogDetails(chargingStation, energySource);
            
        }else {
            // All charging slots are occupied
            System.out.println("All charging slots are occupied. Waiting...");

            Thread.sleep(3000);
            
            long endTime = System.currentTimeMillis();
			long waitingTime = TimeUnit.MILLISECONDS.toSeconds(endTime - startTime);

            // Check if waiting time exceeds 15 minutes, and if so, remove the car from the queue
            if (waitingTime > 15 * 60) {
            	System.out.println("Search for another charging station complete.");
            }
        }  
    }
}
