package com.script.excobot.cooker.nodes;

import com.script.excobot.cooker.Cooker;
import com.script.excobot.cooker.enums.Food;
import com.script.excobot.cooker.enums.Location;
import com.script.excobot.cooker.generic.Node;
import org.excobot.bot.script.GameScript;
import org.excobot.game.api.methods.media.Bank;
import org.excobot.game.api.methods.tab.Inventory;
import org.excobot.game.api.util.Time;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class Banker extends Node {

    private final GameScript gameScript;

    public Banker(Location location, Food food, GameScript gameScript) {
        super(location, food);
        this.gameScript = gameScript;
    }

    @Override
    protected boolean check() {
        return Bank.isOpen() && Inventory.getCount(food.getId(), false) == 0 ;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void execute() {
        System.out.println(Bank.getCount(food.getId(),false));
        if(Bank.getCount(food.getId(),true) >= 28) {
            if(!Inventory.isEmpty()) {
                Bank.depositInventory();
            }
            Time.sleep(1000,1500);
            if(Bank.isVisible(food.getId())) {
                Bank.withdraw(food.getId(), Bank.Amount.ALL);
                Time.sleep(800,1200);
                Bank.close();
                Cooker.restart = true;
            } else {
                Cooker.search = true;
            }
        } else {
            gameScript.stop();
        }
    }
}

