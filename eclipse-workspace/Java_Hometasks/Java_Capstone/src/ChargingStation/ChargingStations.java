package ChargingStation;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ChargingStations {
	public String nameOfChargingStation;
    public int countCharginglocations;
    public int numberOfFreeStationsAvailable;
    public List<String> availableSourceOfEnergy;
    public Logger stationLogger;

    public ChargingStations(String name, int noOfChargingLocation, String... type) {
        this.nameOfChargingStation = name;
        this.countCharginglocations = noOfChargingLocation;
        this.availableSourceOfEnergy=new ArrayList<>();
        
        for(String t: type)
        {
             this.availableSourceOfEnergy.add(t);
        }
        
        this.numberOfFreeStationsAvailable = noOfChargingLocation; 
    }
}
