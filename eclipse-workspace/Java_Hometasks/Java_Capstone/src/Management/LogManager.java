package Management;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

import ChargingStation.ChargingStations;

public class LogManager {
	public static void chargingStationsLogDetails(ChargingStations chargingStation, String energySource) {
        try {
            Handler fileHandler = new FileHandler("src" + File.separator + "Logs" + File.separator + chargingStation.nameOfChargingStation + "_log.txt", 1024 * 1024 * 10, 1, true);
            fileHandler.setFormatter(new SimpleFormatter());
            Logger chargingStationLogger = Logger.getLogger(chargingStation.nameOfChargingStation + "_log");
            chargingStationLogger.addHandler(fileHandler);
            System.out.println("\n");
            chargingStationLogger.log(Level.INFO, "Charging details for car at " + chargingStation.nameOfChargingStation);
            chargingStationLogger.log(Level.INFO, "Energy Source: " + energySource);
            chargingStationLogger.log(Level.INFO, "No. of free stations available : " + chargingStation.numberOfFreeStationsAvailable);
            chargingStationLogger.log(Level.INFO, "Count of charging locations : " + chargingStation.countCharginglocations);
            chargingStationLogger.log(Level.INFO, "Timestamp: " + new Date());

            fileHandler.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
