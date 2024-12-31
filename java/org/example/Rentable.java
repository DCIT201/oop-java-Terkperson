package org.example;

public interface Rentable {
    public void rent(Customer customer, int days);
    public void returnVehicle();
}
