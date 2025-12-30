public class Car implements Vehicle{
    private final String licencePlate;
    public Car(String licencePlate){
        this.licencePlate=licencePlate;
    }
    @Override
    public String getLicencePlate() {
        return this.licencePlate;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.MEDIUM;
    }
}
