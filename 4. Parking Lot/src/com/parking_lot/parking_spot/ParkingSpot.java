package com.parking_lot.parking_spot;

import com.parking_lot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private int id;
    private boolean isFree;
    private Vehicle Vehicle;

    public  boolean getIsFree(){
        return this.isFree;
    }

    public abstract boolean assignVehicle(Vehicle vehicle);
    public boolean removeVehicle(){
        return true;
    }
}


