package com.script.excobot.nodes;

import com.script.excobot.enums.Food;
import com.script.excobot.enums.Location;
import com.script.excobot.generic.Node;
import org.excobot.Application;
import org.excobot.game.api.methods.media.Bank;
import org.excobot.game.api.methods.media.animable.GameObjects;
import org.excobot.game.api.methods.media.animable.actor.NPCs;
import org.excobot.game.api.methods.tab.Inventory;
import org.excobot.game.api.util.Time;
import org.excobot.game.api.wrappers.media.animable.actor.NPC;
import org.excobot.game.api.wrappers.media.animable.object.GameObject;

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
            object.interact("Bank");
            Time.sleep(1000,2000);
        } else {
            Bank.open();
            Time.sleep(1000,2000);
        }
    }
}
