package com.oocl.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ChatFrame extends JFrame implements ActionListener {
    private JTextArea chatTa;
    private JTextArea friendsTa;
    private JTextField sendTf;
    private JButton sendBtn;
    private JButton shakeBtn;

    public ChatFrame() {
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        init();
        addEvent();
        this.setVisible(true);
    }

    private void init() {
        this.setLayout(new BorderLayout());
        JPanel panLeft = new JPanel(new BorderLayout());
        JPanel panRight = new JPanel(new BorderLayout());
        JPanel panLeftBottom = new JPanel(new BorderLayout());
        JPanel panBtnGroup = new JPanel(new BorderLayout());
        chatTa = new JTextArea(10, 20);

        friendsTa = new JTextArea(10, 10);
        sendTf = new JTextField();
        sendBtn = new JButton("send");
        shakeBtn = new JButton("shake");

        sendTf.setFont(new Font("宋体", Font.BOLD, 18));
        sendTf.setForeground(Color.red);

        chatTa.setFont(new Font("宋体", Font.BOLD, 18));
        chatTa.setForeground(Color.blue);
        panRight.add(friendsTa, BorderLayout.CENTER);
        panLeft.add(new JScrollPane(chatTa), BorderLayout.CENTER);
        panLeft.add(panLeftBottom, BorderLayout.SOUTH);
        panRight.setBorder(new LineBorder(Color.red));

        this.add(panLeft, BorderLayout.CENTER);
        this.add(panRight, BorderLayout.EAST);
        panBtnGroup.add(shakeBtn, BorderLayout.NORTH);
        panBtnGroup.add(sendBtn, BorderLayout.SOUTH);
        panLeftBottom.add(sendTf, BorderLayout.CENTER);
        panLeftBottom.add(panBtnGroup, BorderLayout.EAST);
    }

    private void addEvent() {
        sendBtn.addActionListener(this);
    }

    public static void main(String[] args) {
        new ChatFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String content = sendTf.getText();
        System.out.println(content);
        chatTa.append(content + "\n");
    }

}