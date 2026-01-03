import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {
    private final Map<VehicleSize, List<ParkingSpot>>availableSpots;
    private final Map<Vehicle,ParkingSpot>vehicleToSpotMap;

    public ParkingManager(Map<VehicleSize, List<ParkingSpot>> availableSpots, Map<Vehicle, ParkingSpot> vehicleToSpotMap) {
        this.availableSpots = availableSpots;
        this.vehicleToSpotMap = new HashMap<>();
    }

    //Start looking for smallest spot that can fit the vehicle
    public ParkingSpot findSpotForVehicle(Vehicle vehicle){
         VehicleSize vehicleSize=vehicle.getSize();
         for(VehicleSize vehicleSize1:VehicleSize.values()){
             if(vehicleSize1.ordinal()>=vehicleSize.ordinal()){
                 List<ParkingSpot>spots=availableSpots.get(vehicleSize1);
                 for(ParkingSpot spot:spots){
                     if(spot.isAvailable()){
                         return spot;
                     }
                 }
             }
         }
         return null;
    }
}
