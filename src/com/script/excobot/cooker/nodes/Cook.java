package com.script.excobot.cooker.nodes;

import com.script.excobot.cooker.Constants;
import com.script.excobot.cooker.Cooker;
import com.script.excobot.cooker.enums.Food;
import com.script.excobot.cooker.enums.Location;
import com.script.excobot.cooker.generic.Node;
import org.excobot.game.api.methods.cache.media.Menu;
import org.excobot.game.api.methods.cache.media.Widgets;
import org.excobot.game.api.methods.media.animable.GameObjects;
import org.excobot.game.api.methods.media.animable.actor.Players;
import org.excobot.game.api.methods.scene.Camera;
import org.excobot.game.api.methods.tab.Inventory;
import org.excobot.game.api.methods.tab.Tabs;
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
        return Cooker.restart && Widgets.get(Constants.WIDGET_LOBSTER_PARENT) == null && Inventory.getCount(food.getId(), false) != 0 && Players.getLocal().getInteracting() == null && GameObjects.getNearest(location.getLocationId()).isOnScreen() && GameObjects.getNearest(location.getLocationId()).getLocation().distance(Players.getLocal().getLocation()) < 5 && Players.getLocal().getAnimation() <= 0;
    }

    @Override
    protected void execute() {
        GameObject object = GameObjects.getNearest(location.getLocationId());
        Item item = Inventory.getItem(food.getId());

        if(!Tabs.INVENTORY.isOpen()) {
            Tabs.INVENTORY.open();
            Time.sleep(800,1200);
        }

        System.out.println("ddd");
        item.interact("Use");
        Time.sleep(1400, 1900);
        Item i = Inventory.getSelectedItem();
        if(i!= null) {
            if(i.getId() == food.getId()) {
                if(object.hover()) {
                    if(Menu.getOptionCount() >= 2) {
                        object.click(false);
                        Time.sleep(1000,1500);
                        if(Menu.contains("Use", "Fire")) {
                            Menu.interact("Use", "Fire");
                            Cooker.widget = true;
                        } else {
                            Menu.interact("Cancel");
                            Time.sleep(1000,1500);
                            Camera.turnTo(object);
                            return;
                        }
                    } else {
                        object.interact("Use", "Fire");
                        Cooker.widget = true;
                    }
                }
            }
        }

        Time.sleep(1000,1400);
    }
}
