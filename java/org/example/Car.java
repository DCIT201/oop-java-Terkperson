package org.example;

public class Car extends Vehicle implements Rentable {
    private boolean hasAirConditioner;

    public Car(String vehicleId, String model, double baseRentalRate, boolean hasAirConditioner) {
        super(vehicleId, model, baseRentalRate);
        this.hasAirConditioner = hasAirConditioner;
    }

    public boolean isHasAirConditioner() {
        return hasAirConditioner;
    }

    @Override
    public double calculateRentalCost(int days) {
        return super.getBaseRentalRate() * days + (hasAirConditioner ? 100 : 0);
    }

    @Override
    public boolean isAvailableForRental() {
        return super.getIsAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental() && customer.checkAgeEligibility()) {
            super.setIsAvailable(false);
            System.out.println(super.getVehicleId() + " rented to " + customer.getName());
        } else{
            System.out.println("Car already rented or Invalid age");
        }
    }

    @Override
    public void returnVehicle() {
        setIsAvailable(true);
    }
}
