package com.script.excobot.nodes;

import com.script.excobot.Constants;
import com.script.excobot.enums.Food;
import com.script.excobot.enums.Location;
import com.script.excobot.generic.Node;
import org.excobot.Application;
import org.excobot.game.api.methods.cache.Game;
import org.excobot.game.api.methods.cache.media.Widgets;
import org.excobot.game.api.methods.media.animable.GameObjects;
import org.excobot.game.api.methods.media.animable.actor.Players;
import org.excobot.game.api.methods.tab.Inventory;
import org.excobot.game.api.util.Time;
import org.excobot.game.api.wrappers.media.Item;
import org.excobot.game.api.wrappers.media.animable.object.GameObject;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class Cook extends Node {

    public Cook(Location location, Food food) {
        super(location, food);
    }

    @Override
    protected boolean check() {
        return  Widgets.get(Constants.WIDGET_LOBSTER_PARENT) == null && Inventory.getCount(food.getId(), false) != 0 && Players.getLocal().getInteracting() == null && GameObjects.getNearest(location.getLocationId()).isOnScreen() && Players.getLocal().getAnimation() <= 0;
    }

    @Override
    protected void execute() {
        GameObject object = GameObjects.getNearest(location.getLocationId());
        Item item = Inventory.getItem(food.getId());
        item.interact("Use");
        Time.sleep(1200,1500);
        object.interact("Use");
        Time.sleep(2000,2800);
    }
}
