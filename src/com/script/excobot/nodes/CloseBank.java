package com.script.excobot.nodes;

import com.script.excobot.enums.Food;
import com.script.excobot.enums.Location;
import com.script.excobot.generic.Node;
import org.excobot.game.api.methods.media.Bank;
import org.excobot.game.api.methods.tab.Inventory;
import org.excobot.game.api.util.Time;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class CloseBank extends Node {

    public CloseBank(Location location, Food food) {
        super(location, food);
    }

    @Override
    protected boolean check() {
        return Bank.isOpen() && Inventory.getCount(food.getId(), false) == 28;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void execute() {
        Bank.close();
        Time.sleep(1000,2000);
    }
}
