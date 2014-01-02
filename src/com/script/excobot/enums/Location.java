package com.script.excobot.enums;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public enum Location {

    //7112 open 7111 closed


    Rogues_Den("Rogues Den", 24919, false);
   // Nardah("Nardah", 1, false,0,0),
  //  Catherby("Catherby" , 24915, true, -2,0),
   // Al_Kharid("Al Kharid", 24915, true, 0 , 3);

    private final String name;
    private final int locationId;
    private final boolean door;



    private Location(final String name,final int locationId, final boolean door) {
        this.name = name;
        this.locationId = locationId;
        this.door = door;

    }

    public int getLocationId() {
        return this.locationId;
    }

    public boolean hasDoor() {
        return this.door;
    }

}
