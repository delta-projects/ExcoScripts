package com.script.excobot.cooker.nodes;

import com.script.excobot.cooker.Cooker;
import com.script.excobot.cooker.enums.Food;
import com.script.excobot.cooker.enums.Location;
import com.script.excobot.cooker.generic.Node;
import org.excobot.game.api.methods.media.animable.GameObjects;
import org.excobot.game.api.methods.media.animable.actor.Players;
import org.excobot.game.api.methods.scene.Camera;
import org.excobot.game.api.methods.scene.Movement;
import org.excobot.game.api.util.Time;
import org.excobot.game.api.wrappers.media.animable.object.GameObject;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class CookNotOnScreen extends Node {

    public CookNotOnScreen(Location location, Food food) {
        super(location, food);
    }

    @Override
    protected boolean check() {
        return Cooker.restart && !GameObjects.getNearest(location.getLocationId()).isOnScreen();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void execute() {
        GameObject o = GameObjects.getNearest(location.getLocationId());
        Movement.walkTileMM(o.getLocation());
        while(Players.getLocal().isMoving()) {
            Time.sleep(50);
        }

        if(!o.isOnScreen()) {
            Camera.turnTo(o);
        }

    }
}
