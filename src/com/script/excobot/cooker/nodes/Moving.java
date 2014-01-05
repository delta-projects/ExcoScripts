package com.script.excobot.cooker.nodes;

import com.script.excobot.cooker.enums.Food;
import com.script.excobot.cooker.enums.Location;
import com.script.excobot.cooker.generic.Node;
import org.excobot.game.api.methods.media.animable.actor.Players;
import org.excobot.game.api.util.Time;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class Moving extends Node {

    public Moving(Location location, Food food) {
        super(location, food);
    }

    @Override
    protected boolean check() {
        return Players.getLocal().isMoving();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void execute() {
       while(Players.getLocal().isMoving()) {
           Time.sleep(50);
       }
    }
}
