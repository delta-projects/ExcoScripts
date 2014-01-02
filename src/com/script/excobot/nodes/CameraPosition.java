package com.script.excobot.nodes;

import com.script.excobot.enums.Food;
import com.script.excobot.enums.Location;
import com.script.excobot.generic.Node;
import org.excobot.game.api.methods.cache.Game;
import org.excobot.game.api.methods.media.animable.GameObjects;
import org.excobot.game.api.methods.media.animable.actor.Players;
import org.excobot.game.api.methods.scene.Camera;
import org.excobot.game.api.methods.scene.Movement;
import org.excobot.game.api.methods.tab.Inventory;
import org.excobot.game.api.util.Time;
import org.excobot.game.api.wrappers.media.animable.object.GameObject;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class CameraPosition extends Node {

    public CameraPosition(Location location, Food food) {
        super(location, food);
    }

    @Override
    protected boolean check() {
        return Inventory.getCount(food.getId(), false) == 28 && !GameObjects.getNearest(location.getLocationId()).isOnScreen() && Players.getLocal().getAnimation() <= 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void execute() {
        GameObject object = GameObjects.getNearest(location.getLocationId());
        if(object != null) {
            if(Players.getLocal().getLocation().distance(object.getLocation()) < 8) {
                Camera.turnTo(object);
                Time.sleep(1000,1800);
            } else {
                Movement.walkTileMM(object);
                while(Players.getLocal().isMoving()) {
                    Time.sleep(50);
                }
            }
        }
    }
}
