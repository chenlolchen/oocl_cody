package com.oocl.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class ChatRoom extends JFrame implements ActionListener {

    private JTextArea content;
    private JButton sendBtn;
    private JList nameList;
    private JLabel chatLabel;
    private JScrollPane bar;


    public ChatRoom() {
        this.setSize(800, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        addEvent();
        this.setVisible(true);
    }

    private void init() {
        this.setLayout(null);
//        JLabel label = new JLabel("aaaa");
//        bar = new JScrollPane();

//        nameList = new JList(new String[]{"chen", "john","chen", "john","chen", "john","chen", "john","chen", "john","chen", "john","chen", "john","chen", "john","chen", "john","chen", "john","chen", "john","chen", "john","john","chen", "john","chen", "john","chen", "john","chen", "john","chen", "john","chen", "john","john","chen", "john","chen", "john","chen", "john","chen", "john","chen", "john","chen", "john","john","chen", "john","chen", "john","chen", "john","chen", "john","chen", "john","chen", "john"});
//        nameList.setBounds(700, 0, 100, 600);

//        label.setSize(200,200);
//        bar.add(label);
//        bar.setBounds(700, 0, 200, 600);
//        this.add(label);
//        this.add(nameList);


        JTextArea txaDisplay = new JTextArea("aaaaaasssssssssssssssssssssss");
        JScrollPane scroll = new JScrollPane(txaDisplay);
        scroll.setBounds(700, 0, 200, 600);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scroll);
    }

    private void addEvent() {

    }

    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new ChatRoom();
    }
}
