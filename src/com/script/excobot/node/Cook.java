package com.script.excobot.node;

import com.script.excobot.generic.Node;
import org.excobot.game.api.methods.media.animable.actor.Players;
import org.excobot.game.api.methods.tab.Inventory;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class Cook extends Node {


    @Override
    protected boolean check() {
        return Players.getLocal().getInteracting() == null && Inventory.containsAll();
    }

    @Override
    protected void execute() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
