package com.script.excobot.cooker.nodes;

import com.script.excobot.cooker.enums.Food;
import com.script.excobot.cooker.enums.Location;
import com.script.excobot.cooker.generic.Node;
import org.excobot.game.api.methods.media.Bank;
import org.excobot.game.api.methods.media.animable.actor.NPCs;
import org.excobot.game.api.methods.media.animable.actor.Players;
import org.excobot.game.api.methods.scene.Camera;
import org.excobot.game.api.methods.scene.Movement;
import org.excobot.game.api.methods.tab.Inventory;
import org.excobot.game.api.util.Time;
import org.excobot.game.api.wrappers.media.animable.actor.NPC;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class OpenBank extends Node {

    private final int banker = 5442;

    public OpenBank(Location location, Food food) {
        super(location, food);
    }

    @Override
    protected boolean check() {
        return !Bank.isOpen() && Inventory.getCount(food.getId(), false) == 0 ;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void execute() {
        if(NPCs.getNearest(banker) != null) {
            NPC object = NPCs.getNearest(banker);
            if(object.isOnScreen()) {
                object.interact("Bank");
            } else {
                if(object.getLocation().distance(Players.getLocal().getLocation()) >= 5) {
                    Movement.walkTileMM(object.getLocation());
                } else {
                    Camera.turnTo(object);
                }
            }
            Time.sleep(1000,2000);
        } else {
            Bank.open();
            Time.sleep(1000,2000);
        }
    }
}
