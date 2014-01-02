package com.script.excobot;

import com.script.excobot.enums.Food;
import com.script.excobot.enums.Location;
import com.script.excobot.generic.Data;
import com.script.excobot.generic.Node;
import com.script.excobot.gui.Frame;
import com.script.excobot.nodes.*;
import org.excobot.Application;
import org.excobot.bot.event.listeners.PaintListener;
import org.excobot.bot.script.GameScript;
import org.excobot.bot.script.Manifest;
import org.excobot.game.api.methods.media.Bank;
import org.excobot.game.api.methods.media.animable.actor.Players;
import org.excobot.game.api.methods.tab.Inventory;
import org.excobot.game.api.methods.tab.Skills;
import org.excobot.game.api.util.Random;

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
@Manifest(authors = "Delta & Tz TokJAd" , name = "Rouge's den Cooker", description = "Beta: Cooks most food in the rouge's Den" , version=1.3D)
public class Cooker extends GameScript implements PaintListener {

    private final List<Node> nodes = Collections.synchronizedList(new ArrayList<Node>());
    public final static HashMap<String, Data> data = new HashMap<String, Data>();
    public static boolean guiVisible = true;
    public static int cooked = 0;
    private Frame frame;
    private int startXp;
    private int xpGained;
    private long startTime;
    private int perHour;
    public static boolean search = false;

    private synchronized void addNode(final Node...nodes) {
        for(final Node node : nodes) {
            if(!this.nodes.contains(node)) {
                this.nodes.add(node);
            }
        }
    }

    @Override
    public boolean start() {
        frame = new Frame();
        startTime = System.currentTimeMillis();
        return Players.getLocal().isOnScreen();
    }


    @Override
    public void repaint(Graphics graphics) {
        if(startXp == 0) {
            startXp = Skills.COOKING.getExperience();
        }

        if(Players.getLocal().isOnScreen()) {
            graphics.setColor(Color.GREEN);
            long runTime = System.currentTimeMillis() - startTime;
            xpGained = Skills.COOKING.getExperience() - startXp;
            cooked = xpGained/120;
            perHour = (int) Math.floor((xpGained* 3600000D / runTime));
            graphics.drawString("AIO Cooker by delta and TzTok Jad", 50, 100);
            graphics.drawString("XP Gained = " + xpGained, 50, 120);
            graphics.drawString("XP per hour = " + perHour, 50 , 140);
            graphics.drawString("Food cooked = " + Cooker.cooked , 50, 160);
        }
    }


    @Override
    public int execute() throws InterruptedException {
        if(frame.isVisible()) {
            return 100;
        }

        if(!data.isEmpty()) {
            Food food = (Food) data.get("Food").getData();
            Location location = (Location) data.get("Location").getData();

            addNode(new Node[]{
                    new OpenBank(location,food),
                    new Antiban(location, food),
                    new Banker(location,food),
                    new CloseBank(location,food),
                    new CameraPosition(location, food),
                    new SearchBank(location,food),
                    new Cook(location,food),
                    new CookWidgetHandler(location,food)
            });

            data.clear();
        }

        for(final Node node : nodes) {
            node.run();

        }

        return Random.nextInt(10,180);
    }


}
