package com.script.excobot;

import com.script.excobot.generic.Node;
import org.excobot.bot.event.listeners.PaintListener;
import org.excobot.bot.script.GameScript;
import org.excobot.game.api.util.Random;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class Cooker extends GameScript implements PaintListener {

    private final List<Node> nodes = Collections.synchronizedList(new ArrayList<Node>());

    private void addNode(final Node...nodes) {
        for(final Node node : nodes) {
             if(!this.nodes.contains(node)) {
                    this.nodes.add(node);
             }
        }
    }

    @Override
    public boolean start() {
        addNode(new Node[] {

        });

        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void repaint(Graphics graphics) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int execute() throws InterruptedException {
        return Random.nextInt(50,80);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
