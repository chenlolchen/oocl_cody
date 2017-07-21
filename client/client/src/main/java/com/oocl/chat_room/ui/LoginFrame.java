package com.oocl.chat_room.ui;

import com.oocl.chat_room.action.impl.LoginAction;
import com.oocl.chat_room.pojo.User;
import com.oocl.chat_room.protocol.DataPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class LoginFrame extends JFrame implements ActionListener, Runnable {
    private JTextField nameTF;
    private JPasswordField psdPF;
    private JButton loginBtn;
    private JButton cancelBtn;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private LoginAction loginAction;
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public LoginFrame() {
        try {
            this.loginAction = new LoginAction(new Socket("127.0.0.1", 8002), this);
            flag = true;
        } catch (IOException e) {
            this.setTitle("server error");
        }
        this.setSize(400, 260);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        addEvent();
        this.setVisible(true);
    }

    private void init() {
        this.setLayout(null);
        nameTF = new JTextField();
        psdPF = new JPasswordField();
        loginBtn = new JButton("login");
        cancelBtn = new JButton("cancel");
        usernameLabel = new JLabel("username");
        passwordLabel = new JLabel("password");


        usernameLabel.setBounds(10, 30, 60, 20);
        passwordLabel.setBounds(10, 90, 60, 20);
        nameTF.setBounds(78, 20, 300, 40);
        psdPF.setBounds(78, 80, 300, 40);
        loginBtn.setBounds(78, 140, 90, 40);
        cancelBtn.setBounds(180, 140, 90, 40);

        getRootPane().setDefaultButton(loginBtn);
        passwordLabel.requestFocus();

        this.add(nameTF);
        this.add(psdPF);
        this.add(loginBtn);
        this.add(cancelBtn);
        this.add(usernameLabel);
        this.add(passwordLabel);
    }

    private void addEvent() {
        loginBtn.addActionListener(this);
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (loginAction == null){
            showServerErrorDialog();
        }else {
            loginAction.sendDataPackage(new DataPackage(nameTF.getText(), "server", DataPackage.MessageType.LOGIN, psdPF.getText()));
        }
    }

    public void showErrorDialog() {
        JOptionPane.showMessageDialog(null, "login error");
    }

    public void showChatFrameUI(User user) {
        try {
            new Thread(new ChatFrame(new Socket("127.0.0.1", 8888), user)).start();
            this.dispose();
        } catch (IOException e) {
            showErrorDialog();
        }
    }

    private void showServerErrorDialog(){
        JOptionPane.showMessageDialog(null, "server error");
    }

    @Override
    public void run() {
        while (flag) {
            DataPackage dataPackage = loginAction.receiveDataPackage();
            loginAction.handleDataPackage(dataPackage);
        }
    }
}
