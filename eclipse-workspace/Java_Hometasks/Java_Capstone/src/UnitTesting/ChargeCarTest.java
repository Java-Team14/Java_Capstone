package UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ChargingStation.ChargeCar;
import ChargingStation.ChargingStations;

class ChargeCarTest {

	 @Test
	    void testChargeCarWithAvailableSlot() throws InterruptedException {
	        ChargingStations chargingStation = new ChargingStations("TestStation", 2, "Diesel");
	        int initialFreeSlots = chargingStation.numberOfFreeStationsAvailable;

	        ChargeCar.chargeCar(chargingStation, "Diesel");

	        assertEquals(initialFreeSlots, chargingStation.numberOfFreeStationsAvailable);
	    }

	    @Test
	    void testChargeCarWithNoAvailableSlot() throws InterruptedException {
	        ChargingStations chargingStation = new ChargingStations("TestStation", 0, "Diesel");
	        int initialFreeSlots = chargingStation.numberOfFreeStationsAvailable;

	        ChargeCar.chargeCar(chargingStation, "Diesel");

	        assertEquals(initialFreeSlots, chargingStation.numberOfFreeStationsAvailable);
	    }

	    @Test
	    void testChargeCarWaitingTimeExceeded() throws InterruptedException {

	        // Wait for more than 15 minutes
	        Thread.sleep(16 * 60 * 1000);
	        
	        //uncomment line 40 and comment line 36 to get result in 15 seconds instead of 16 minutes
	        //(For testing purpose)
	        //Thread.sleep(1 * 15 * 1000);
	    }

}
