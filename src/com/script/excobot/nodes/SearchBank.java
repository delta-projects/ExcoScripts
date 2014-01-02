package com.script.excobot.nodes;

import com.script.excobot.Constants;
import com.script.excobot.Cooker;
import com.script.excobot.enums.Food;
import com.script.excobot.enums.Location;
import com.script.excobot.generic.Node;
import org.excobot.game.api.methods.cache.media.Widgets;
import org.excobot.game.api.methods.input.Keyboard;
import org.excobot.game.api.methods.media.Bank;
import org.excobot.game.api.methods.tab.Inventory;
import org.excobot.game.api.util.Time;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class SearchBank extends Node {

    public SearchBank(Location location, Food food) {
        super(location, food);
    }

    @Override
    protected boolean check() {
        return Bank.isOpen() && Cooker.search && (Inventory.getCount(food.getCookedId(), false) == 28 ||  Inventory.getCount(food.getId(), false) == 0);
    }

    @Override
    protected void execute() {
        Widgets.get(Constants.WIDGET_BANK_SEARCH_PARENT).getChild(Constants.WIDGET_BANK_SEARCH_CHILD).click(true);
        if(Widgets.get(Constants.WIDGET_MESSAGE_PARENT).getChild(Constants.WIDGET_MESSAGE_CHILD).getText().contains("items")) {
            Time.sleep(750, 1500);
            Keyboard.sendKeys("raw", true);
            Time.sleep(1200,1800);
            Bank.withdraw(food.getId(), Bank.Amount.ALL);
            Time.sleep(750,1500);
            Bank.close();
            Cooker.search = false;
        }
    }
}

