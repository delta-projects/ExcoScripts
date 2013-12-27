package com.script.excobot.enums;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public enum Location {

    //7112 open 7111 closed


    Rogues_Den("Rogues Den", 24919),
    Nardah("Nardah", 1),
    Catherby("Catherby" , 24195),
    Al_Kharid("Al Kharid", 24195);

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
