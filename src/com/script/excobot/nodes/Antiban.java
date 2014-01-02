package com.script.excobot.nodes;

import com.script.excobot.enums.Food;
import com.script.excobot.enums.Location;
import com.script.excobot.generic.Node;

import org.excobot.Application;
import org.excobot.game.api.methods.cache.media.Widgets;
import org.excobot.game.api.methods.media.Bank;
import org.excobot.game.api.methods.media.animable.actor.Players;
import org.excobot.game.api.methods.scene.Camera;
import org.excobot.game.api.methods.tab.Tabs;
import org.excobot.game.api.util.Random;
import org.excobot.game.api.util.Time;
import com.script.excobot.Constants;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class Antiban extends Node {

    public Antiban(Location location, Food food) {
        super(location, food);
    }

    @Override
    protected boolean check() {
        return Players.getLocal().getInteracting() == null && isAnimating();
    }

    @Override
    protected void execute() {
        int random = Random.nextInt(0,130);
        switch (random) {
           case 1:
                Time.sleep(Random.nextInt(10000,(30000+Random.nextInt(1000, 10000))));
                break;
            case 2:
                Camera.setAngle(Random.nextInt(0,340));
                break;
            case 3:
                Camera.setPitch(Random.nextInt(0,110));
            case 4:
                Camera.setAngle(Random.nextInt(0,340));
                Time.sleep(500,800);
                Camera.setPitch(Random.nextInt(0,110));
                break;
            case 5:
                Tabs.SKILLS.open();
                Time.sleep(800,1300);
                if(Tabs.SKILLS.isOpen()) {
                    Widgets.get(Constants.WIDGET_COOKING_ICON_PARENT).getChild(Constants.WIDGET_COOKING_ICON_CHILD).getChild(Constants.WIDGET_COOKING_ICON_CHILD_SUB_CHILD).hover();
                    Time.sleep(1000,4000);
                }
                Tabs.INVENTORY.open();
                break;
        }

    }

    private boolean isAnimating() {
       return Players.getLocal().getAnimation() > 0;
    }
}
