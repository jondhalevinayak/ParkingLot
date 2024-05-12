import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    List<CompactSpot> compactSpotList = new ArrayList<>();
    List<LargeSpot> largeSpotList = new ArrayList<>();
    List<BikeSpot> bikeSpotList = new ArrayList<>();

    int availableCompactSpots;
    int availablLargeSpots;
    int availableBikeSpots;

    public ParkingLot(int availableCompactSpots, int availablLargeSpots, int availableBikeSpots) {
        this.availableCompactSpots = availableCompactSpots;
        this.availablLargeSpots = availablLargeSpots;
        this.availableBikeSpots = availableBikeSpots;
    }

    //parkingVehicle
    public void parkVehicle(Vehicle vehicle) {
        if (vehicle.getVehicleType().equals(VehicleType.TRUCK)) {
            if (availablLargeSpots > 0) {
                parkYourLargeVehicle(vehicle);
            } else {
                System.out.println("All large spots are full");
            }
        } else if (vehicle.getVehicleType().equals(VehicleType.CAR)) {
            if (availableCompactSpots > 0) {
                parkYourCompactVehicle(vehicle);
            } else if (availablLargeSpots > 0) {
                parkYourLargeVehicle(vehicle);
            } else {
                System.out.println("All large spots are full");
            }
        } else if (vehicle.getVehicleType().equals(VehicleType.BIKE)) {
            if (availableCompactSpots > 0) {
                parkYourCompactVehicle(vehicle);
            } else if (availablLargeSpots > 0) {
                parkYourLargeVehicle(vehicle);
            } else if (availableBikeSpots > 0) {
                parkYourBikeVehicle(vehicle);
            } else {
                System.out.println("All large spots are full");
            }
        }
    }

    private void parkYourBikeVehicle(Vehicle vehicle) {
        BikeSpot bikeSpot = new BikeSpot(ParkingSpotType.BIKE);
        bikeSpot.setAvailable(false);
        bikeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(bikeSpot);

        bikeSpotList.add(bikeSpot);
        availableBikeSpots--;
        System.out.println("Successfully parked your "+vehicle.getVehicleType()+" vehicle");
    }

    private void parkYourCompactVehicle(Vehicle vehicle) {
        CompactSpot compactSpot = new CompactSpot(ParkingSpotType.COMPACT);
        compactSpot.setAvailable(false);
        compactSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(compactSpot);

        compactSpotList.add(compactSpot);
        availableCompactSpots--;
        System.out.println("Successfully parked your "+vehicle.getVehicleType()+" vehicle");
    }

    private void parkYourLargeVehicle(Vehicle vehicle) {
        LargeSpot largeSpot = new LargeSpot(ParkingSpotType.LARGE);
        largeSpot.setAvailable(false);
        largeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(largeSpot);

        largeSpotList.add(largeSpot);
        availablLargeSpots--;
        System.out.println("Successfully parked your "+vehicle.getVehicleType()+" vehicle");

    }

    //unParkCar
    public void unparkVehicle(Vehicle vehicle) {

        ParkingSpot parkingSpot = vehicle.getParkingSpot();
        System.out.println("Successfully un-parked your "+vehicle.getVehicleType()+" vehicle");

        if (parkingSpot.getParkingSpotType().equals(ParkingSpotType.LARGE)) {
            largeSpotList.remove(parkingSpot);
            availablLargeSpots++;
            System.out.println("availablLargeSpots :: "+availablLargeSpots);
        }
        if (parkingSpot.getParkingSpotType().equals(ParkingSpotType.COMPACT)) {
            compactSpotList.remove(parkingSpot);
            availableCompactSpots++;
            System.out.println("availableCompactSpots :: "+availableCompactSpots);
        }
        if (parkingSpot.getParkingSpotType().equals(ParkingSpotType.BIKE)) {
            bikeSpotList.remove(parkingSpot);
            availableBikeSpots++;
            System.out.println("availableBikeSpots :: "+availableBikeSpots);
        }
    }

}



