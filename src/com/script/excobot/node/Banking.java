package com.script.excobot.node;

import com.script.excobot.Constants;
import com.script.excobot.Cooker;
import com.script.excobot.enums.Food;
import com.script.excobot.generic.Node;
import org.excobot.Application;
import org.excobot.game.api.methods.cache.media.Widgets;
import org.excobot.game.api.methods.input.Keyboard;
import org.excobot.game.api.methods.media.Bank;
import org.excobot.game.api.methods.media.animable.actor.Players;
import org.excobot.game.api.methods.tab.Inventory;
import org.excobot.game.api.util.Time;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class Banking extends Node {

    private final Food food;

    public Banking() {
        this.food = (Food) Cooker.data.get("Food").getData();
    }

    @Override
    protected boolean check() {
        return Inventory.getItem(this.food.getId()) == null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void execute() {

        Application.log(Inventory.contains(food.getId()) + " " + food.getId());

         if(Bank.open()) {
             Bank.depositAll();
             Time.sleep(1500, 2000);
             if(Bank.isVisible(Bank.getItem(food.getId()))) {
                 Bank.withdraw(food.getId(), Bank.Amount.ALL);
                 Time.sleep(750,1500);
                 Bank.close();
                 return;
             } else {
                 Widgets.get(Constants.WIDGET_BANK_SEARCH_PARENT).getChild(Constants.WIDGET_BANK_SEARCH_CHILD).click(true);
                 if(Widgets.get(Constants.WIDGET_MESSAGE_PARENT).getChild(Constants.WIDGET_MESSAGE_CHILD).getText().contains("items")) {
                     Time.sleep(750,1500);
                     Keyboard.sendKeys("raw", true);
                     Time.sleep(1200,1800);
                     Bank.withdraw(food.getId(), Bank.Amount.ALL);
                     Time.sleep(750,1500);
                     Bank.close();
                     return;
                 }
             }
         }

    }
}
