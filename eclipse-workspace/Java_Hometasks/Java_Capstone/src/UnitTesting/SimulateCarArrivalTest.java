package UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

import ChargingStation.ChargingStations;
import ChargingStation.SimulateCarArrival;

class SimulateCarArrivalTest {

	private ChargingStations testStation;

    @Test
    void testSimulateCarArrivalWithElectricVehicle() {
        
        String input = "yes\nDiesel\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> {
            SimulateCarArrival.simulateCarArrival(testStation);
        });
    }

    @Test
    void testSimulateCarArrivalWithNonElectricVehicle() {
        
        String input = "no\nSunny\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> SimulateCarArrival.simulateCarArrival(testStation));
    }
    
}
