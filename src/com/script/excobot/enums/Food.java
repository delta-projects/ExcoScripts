package com.script.excobot.enums;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public enum Food {

    Shark("Raw shark", 383, 385, 387),
    Lobster("Raw lobster", 377, 379, 381),
    Shrimp("Raw shrimps" , 317, 319, 321),
    Swordfish("Raw swordfish" , 371, 373, 375),
    Trout("Raw trout" , 335, 337, 339),
    Herring("Raw herring" ,345, 347, 349);

    private final String name;
    private final int id;
    private final int cookedId;
    private final int burntId;

    private Food(final String name, final int id, final int cookedId, final int burntId) {
        this.name = name;
        this.id = id;
        this.cookedId = cookedId;
        this.burntId = burntId;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getCookedId() {
        return this.cookedId;
    }

    public int getBurntId() {
        return this.burntId;
    }
}
