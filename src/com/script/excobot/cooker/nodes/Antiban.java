package com.script.excobot.cooker.nodes;

import org.excobot.game.api.methods.cache.media.Widgets;
import org.excobot.game.api.methods.scene.Camera;
import org.excobot.game.api.methods.tab.Tabs;
import org.excobot.game.api.util.Random;
import org.excobot.game.api.util.Time;
import com.script.excobot.cooker.Constants;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class Antiban  {

    public static void execute() {
        int random = Random.nextInt(0,175);
        switch (random) {
            case 2:
                Camera.setAngle(Random.nextInt(0,340));
                break;
            case 3:
                Camera.setPitch(Random.nextInt(0,110));
            case 4:
                Camera.setAngle(Random.nextInt(0,340));
                Time.sleep(500,800);
                Camera.setPitch(Random.nextInt(0,110));
                break;
            case 5:
                Tabs.SKILLS.open();
                Time.sleep(800,1300);
                if(Tabs.SKILLS.isOpen()) {
                    Widgets.get(Constants.WIDGET_COOKING_ICON_PARENT).getChild(Constants.WIDGET_COOKING_ICON_CHILD).getChild(Constants.WIDGET_COOKING_ICON_CHILD_SUB_CHILD).hover();
                    Time.sleep(1000,4000);
                }
                Tabs.INVENTORY.open();
                break;
        }

    }

}
