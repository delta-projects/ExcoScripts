package com.script.excobot.enums;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public enum Food {


    Shark("Raw shark", 383),
    Lobster("Raw lobster", 377),
    Shrimp("Raw shrimps" , 317),
    Swordfish("Raw swordfish" , 371),
    Trout("Raw trout" , 335),
    Herring("Raw herring" ,345);

    private final String name;
    private final int id;

    private Food(final String name, final int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}
