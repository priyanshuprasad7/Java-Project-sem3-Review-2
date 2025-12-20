package com.parking.gui;

import javax.swing.*;

public class ParkingGUI {

    public static void main(String[] args) {
        JFrame f = new JFrame("Parking System");
        JTextField t = new JTextField();
        JButton b = new JButton("Park Vehicle");

        t.setBounds(50,50,150,30);
        b.setBounds(50,100,150,30);

        f.add(t);
        f.add(b);

        f.setSize(300,250);
        f.setLayout(null);
        f.setVisible(true);
    }
}
