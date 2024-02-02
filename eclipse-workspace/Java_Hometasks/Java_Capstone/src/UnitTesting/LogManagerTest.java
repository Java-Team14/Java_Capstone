package UnitTesting;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import org.junit.jupiter.api.Test;

import ChargingStation.ChargingStations;
import Management.LogManager;

class LogManagerTest {

	@Test
    void testChargingStationsLogDetails() {
        ChargingStations chargingStation = new ChargingStations("TestStation", 5, "Solar", "Wind");
        String energySource = "Solar";

        LogManager.chargingStationsLogDetails(chargingStation, energySource);

        assertTrue(new File("src/Logs/TestStation_log.txt").exists());
    }

}
