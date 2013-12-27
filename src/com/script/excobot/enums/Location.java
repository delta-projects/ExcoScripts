package com.script.excobot.enums;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public enum Location {


    Rogues_Den("Rogues Den", 1),
    Nardah("Nardah", 1),
    Catherby("Catherby" , 1),
    Al_Kharid("Al Kharid",1);

    private final String name;
    private final int locationId;


    private Location(String name, int locationId) {
        this.name = name;
        this.locationId = locationId;
    }

    public int getLocationId() {
        return this.locationId;
    }
}
