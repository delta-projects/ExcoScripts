package com.script.excobot.cooker.nodes;

import com.script.excobot.cooker.Constants;
import com.script.excobot.cooker.Cooker;
import com.script.excobot.cooker.enums.Food;
import com.script.excobot.cooker.enums.Location;
import com.script.excobot.cooker.generic.Node;
import org.excobot.game.api.methods.cache.media.Widgets;
import org.excobot.game.api.methods.media.animable.actor.Players;
import org.excobot.game.api.util.Time;
import org.excobot.game.api.wrappers.cache.media.Component;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class CookWidgetHandler extends Node {

    public CookWidgetHandler(Location location, Food food) {
        super(location, food);
    }

    @Override
    protected boolean check() {
        return Players.getLocal().getAnimation() <= 0 &&  Widgets.get(Constants.WIDGET_LOBSTER_PARENT) != null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void execute() {
        Component widget = Widgets.get(Constants.WIDGET_LOBSTER_PARENT).getChild(Constants.WIDGEt_LOBSTER_CHILD);
        widget.interact("Cook All");
        Time.sleep(1000,2000);
        Cooker.restart = false;
        Cooker.widget = false;
    }
}
