package com.oocl.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class Abc extends JFrame {

    private JPanel sad;
    private JButton button1;


//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Abc");
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Abc");
//        frame.setContentPane(new Abc().sad);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Abc() {
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here


    }
}
