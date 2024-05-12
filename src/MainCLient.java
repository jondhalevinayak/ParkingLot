public class MainCLient {

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(2,2,2);
        Vehicle vehicle = new Vehicle(VehicleType.TRUCK);



        parkingLot.parkVehicle(vehicle);
        parkingLot.unparkVehicle(vehicle);
    }
}
