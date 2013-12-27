package com.script.excobot.gui;

import com.script.excobot.Cooker;
import com.script.excobot.enums.Food;
import com.script.excobot.enums.Location;
import com.script.excobot.generic.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class Frame extends JFrame {

    private JPanel panel;
    private JComboBox comboBox;
    private JComboBox locationBox;
    private JLabel title;
    private JLabel foodLabel;
    private JLabel locationLabel;
    private JButton button;

    public Frame() {
        init();
    }

    private void init() {
        setSize(new Dimension(300,270));
        setTitle("AIO Cooker");
        setLayout(null);
        setResizable(false);
        add(getBigTitle(),null);
        add(getComboBox(),null);
        add(getLocationBox(),null);
        for(JLabel label : getLabels()) {
            add(label,null);
        }
        add(startButton(),null);
        setVisible(true);
    }

    private JButton startButton() {
        this.button = new JButton("Start");
        this.button.setBounds(200,200,75,20);
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Cooker.data.size() == 2) {
                    dispose();
                    Cooker.guiVisible = false;
                }
            }
        });
        return this.button;
    }

    private JLabel[] getLabels() {
        JLabel[] array = new JLabel[2];
        this.foodLabel = new JLabel("Food");
        this.foodLabel.setBounds(20,100,80,25);
        array[0] = this.foodLabel;

        this.locationLabel = new JLabel("Location");
        this.locationLabel.setBounds(20,150,80,25);
        array[1] = this.locationLabel;

       return array;
    }

    private JLabel getBigTitle() {
        this.title = new JLabel("AIO Cooker");
        this.title.setFont(new Font("monotype corsiva", Font.PLAIN, 38));
        this.title.setBounds(20, 20, 200, 60);
        return this.title;
    }

    private JComboBox getComboBox() {
        this.comboBox = new JComboBox();
        this.comboBox.setModel(new DefaultComboBoxModel(Food.values()));
        this.comboBox.setBounds(100,100,100,25);
        this.comboBox.setSelectedIndex(0);
        this.comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Food food = (Food) comboBox.getSelectedItem();
                if(food != null) {
                    Cooker.data.put("Food_ID" , new Data(food.getId()));
                }
            }
        });
        return this.comboBox;
    }

    private JComboBox getLocationBox() {
        this.locationBox = new JComboBox();
        this.locationBox.setModel(new DefaultComboBoxModel(Location.values()));
        this.locationBox.setBounds(100,150,100,25);
        this.locationBox.setSelectedIndex(0);
        this.locationBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Location location = (Location) locationBox.getSelectedItem();
                if(location != null) {
                    Cooker.data.put("Location_ID" , new Data(location.getLocationId()));
                }
            }
        });
        return locationBox;
    }

}
