package com.script.excobot.generic;

import com.script.excobot.Constants;
import com.script.excobot.enums.Food;
import com.script.excobot.enums.Location;
import org.excobot.Application;
import org.excobot.game.api.methods.media.animable.GameObjects;
import org.excobot.game.api.wrappers.media.animable.object.GameObject;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public abstract class Node {

    protected final Location location;
    protected final Food food;

    public Node(final Location location, final Food food) {
        this.location = location;
        this.food = food;
    }

    protected abstract boolean check();

    protected abstract void execute();

    public void run() {
        if(check()) {
            execute();
        }
    }

    private GameObject getDoor() {
        for(final GameObject object : GameObjects.getLoaded()) {
            if(object.getId() == Constants.DOOR_CLOSED) {
                if(object.getLocation().distance(GameObjects.getNearest(location.getLocationId())) < 7) {
                    return object;
                }
            }
        }
        return null;
    }

}
