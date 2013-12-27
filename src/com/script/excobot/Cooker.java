package com.script.excobot;

import com.script.excobot.generic.Data;
import com.script.excobot.generic.Node;
import com.script.excobot.gui.Frame;
import com.script.excobot.gui.javafx.Form;
import com.script.excobot.node.Antiban;
import org.excobot.bot.event.listeners.PaintListener;
import org.excobot.bot.script.GameScript;
import org.excobot.bot.script.Manifest;
import org.excobot.game.api.methods.input.Mouse;
import org.excobot.game.api.methods.media.animable.actor.Players;
import org.excobot.game.api.util.Random;
import org.excobot.game.api.util.Time;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
@Manifest(authors = "Delta & Tz TokJAd" , name = "AIO Cookerrrrrrrrrrr", description = "Cooks Food" , version=1.3D)
public class Cooker extends GameScript implements PaintListener {

    private final List<Node> nodes = Collections.synchronizedList(new ArrayList<Node>());
    public static HashMap<String, Data> data = new HashMap<String, Data>();
    public static boolean guiVisible = true;
    private Frame frame;

    private void addNode(final Node...nodes) {
        for(final Node node : nodes) {
             if(!this.nodes.contains(node)) {
                    this.nodes.add(node);
             }
        }
    }

    @Override
    public boolean start() {
        frame = new Frame();
        addNode(new Node[]{

                new Antiban()
        });

        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public void repaint(Graphics graphics) {
        graphics.drawRect(Mouse.getX(), Mouse.getY() , 50,50);
    }

    @Override
    public int execute() throws InterruptedException {
        for(final Node node : nodes) {
            node.run();
        }
        return Random.nextInt(10,180);  //To change body of implemented methods use File | Settings | File Templates.
    }


}
