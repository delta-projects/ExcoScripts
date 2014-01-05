package com.script.excobot.cooker.nodes;

import com.script.excobot.cooker.Cooker;
import com.script.excobot.cooker.enums.Food;
import com.script.excobot.cooker.enums.Location;
import com.script.excobot.cooker.generic.Node;
import org.excobot.game.api.methods.media.animable.actor.Players;
import org.excobot.game.api.methods.tab.Inventory;
import org.excobot.game.api.util.Time;
import org.excobot.game.api.util.Timer;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class Animation extends Node {

    public Animation(Location location, Food food) {
        super(location, food);
    }

    @Override
    protected boolean check() {
        return  !Cooker.widget && Players.getLocal().getAnimation() <= 0 && !Cooker.restart;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void execute() {
        Timer timer = new Timer(5000);
        while(timer.isRunning() && Inventory.getCount(food.getId(), false) > 0) {
            Time.sleep(1000);
            if(Players.getLocal().getAnimation() >= 1) {
                timer.reset();
                Antiban.execute();
            }
            System.out.println(timer.getElapsed());
        }

        if(Players.getLocal().getAnimation() <= 0) {
            Cooker.restart = true;
        }
    }
}
