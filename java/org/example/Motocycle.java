package org.example;

public class Motocycle extends Vehicle implements Rentable {
    private int helmetCost = 33;

    public Motocycle(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    public int getHelmetCost() {
        return helmetCost;
    }

    @Override
    public double calculateRentalCost(int days) {
        return super.getBaseRentalRate() * days + helmetCost;
    }

    @Override
    public boolean isAvailableForRental() {
        return super.getIsAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental() && customer.checkAgeEligibility()) {
            setIsAvailable(false);
            System.out.println(super.getVehicleId() + " rented to " + customer.getName());
        } else{
            System.out.println("Motocycle already rented or Invalid age");
        }
    }

    @Override
    public void returnVehicle() {
        setIsAvailable(true);
    }
}

