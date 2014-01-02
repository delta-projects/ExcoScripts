package com.script.excobot.nodes;

import com.script.excobot.Cooker;
import com.script.excobot.enums.Food;
import com.script.excobot.enums.Location;
import com.script.excobot.generic.Node;
import org.excobot.game.api.methods.media.Bank;
import org.excobot.game.api.methods.media.animable.GameObjects;
import org.excobot.game.api.methods.tab.Inventory;
import org.excobot.game.api.util.Time;
import org.excobot.game.api.wrappers.media.Item;
import org.excobot.game.api.wrappers.media.animable.object.GameObject;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class Banker extends Node {



    public Banker(Location location, Food food) {
        super(location, food);
    }

    @Override
    protected boolean check() {
        return Bank.isOpen() && Inventory.getCount(food.getId(), false) == 0 ;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void execute() {
        if(Bank.contains(food.getId())) {
            Bank.depositAll();
            Time.sleep(1000,1500);
            if(Bank.isVisible(food.getId())) {
                Bank.withdraw(food.getId(), Bank.Amount.ALL);
                Time.sleep(800,1200);
                Bank.close();
            } else {
                Cooker.search = true;
            }
        }
    }
}

