package UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class CapstoneMainTest {

	@Test
    void testChargingStationLoggerInitialization() {
        assertTrue(Files.exists(Paths.get("src" + File.separator + "Logs" + File.separator + "Ionity_log.txt")));
    }

    @Test
    void testChargingStationLoggerInitialization1() {
        assertTrue(Files.exists(Paths.get("src" + File.separator + "Logs" + File.separator + "Vattenfall_log.txt")));
    }
    
    @Test
    void testChargingStationLoggerInitialization2() {
        assertTrue(Files.exists(Paths.get("src" + File.separator + "Logs" + File.separator + "FastEnd_log.txt")));
    }

    @Test
    void testChargingStationLoggerInitialization3() {
        assertTrue(Files.exists(Paths.get("src" + File.separator + "Logs" + File.separator + "Ladestation_log.txt")));
    }
    
    @Test
    void testInvalidChargingStationLoggerInitialization() {
        assertFalse(Files.exists(Paths.get("src" + File.separator + "Logs" + File.separator + "Dortmund_log.txt")));
    }
}
