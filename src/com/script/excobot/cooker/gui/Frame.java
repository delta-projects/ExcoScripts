package com.script.excobot.cooker.gui;

import com.script.excobot.cooker.Cooker;
import com.script.excobot.cooker.enums.Food;
import com.script.excobot.cooker.enums.Location;
import com.script.excobot.cooker.generic.Data;

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
        //add(getLocationBox(),null);
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
                if (Cooker.data.size() == 1) {
                    Cooker.data.put("Location", new Data(Location.Rogues_Den));
                    dispose();
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
                    Cooker.data.put("Food" , new Data<Food>(food));
                }
            }
        });
        return this.comboBox;
    }

    private JComboBox getLocationBox() {
        this.locationBox = new JComboBox();
        this.locationBox.setModel(new DefaultComboBoxModel(Location.values()));
        this.locationBox.setBounds(100,150,100,25);
       /* this.locationBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Location location = Location.Rogues_Den;
                if(location != null) {
                    Cooker.data.put("Location" , new Data(location));
                }
            }
        }); */
        return locationBox;
    }

}
