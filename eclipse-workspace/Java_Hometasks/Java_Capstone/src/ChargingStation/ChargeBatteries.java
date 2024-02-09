package ChargingStation;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChargeBatteries {
	private static final Logger solarLogger = Logger.getLogger("Solar Energy");
    private static final Logger windLogger = Logger.getLogger("Wind Energy");
    private static final Logger hydroLogger = Logger.getLogger("Hydro Energy");
    
	public static void chargeBatteries(ChargingStations chargingStation, String elecEnergy) throws InterruptedException {
        System.out.println("Charging started at " + new Date() + " for station " +
                chargingStation.nameOfChargingStation + " with " + elecEnergy);

        Thread.sleep(5000);

        System.out.println("Charging completed. Thank you!");

	String logMessage = "Charging completed at " + new Date() +
                " for station " + chargingStation.nameOfChargingStation +
        			" with energy source " + elecEnergy;
        //chargingStation.stationLogger.log(Level.INFO, logMessage);

	   // Information on energy logs
        if ("Solar Energy".equals(elecEnergy)) {
        	solarLogger.log(Level.INFO, logMessage);
        } else if ("Wind Energy".equals(elecEnergy)) {
        	windLogger.log(Level.INFO, logMessage);
        } else if ("Hydro Energy".equals(elecEnergy)) {
        	hydroLogger.log(Level.INFO, logMessage);
        }
    }
}
