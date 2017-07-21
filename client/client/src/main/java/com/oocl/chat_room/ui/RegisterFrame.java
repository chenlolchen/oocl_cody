package com.oocl.chat_room.ui;

import com.oocl.chat_room.action.impl.RegisterAction;
import com.oocl.chat_room.protocol.DataPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class RegisterFrame extends JFrame implements ActionListener, Runnable {
    private JTextField nameTF;
    private JPasswordField psdPF;
    private JButton registerBtn;
    private JButton cancelBtn;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private RegisterAction registerAction;
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public RegisterFrame() {
        this.setSize(400, 260);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        addEvent();
        this.setVisible(true);
        try {
            registerAction = new RegisterAction(new Socket("127.0.0.1", 8001), this);
        } catch (Exception e) {
            this.setTitle("server no start");
        }
    }

    private void init() {
        this.setLayout(null);
        nameTF = new JTextField();
        psdPF = new JPasswordField();
        registerBtn = new JButton("register");
        cancelBtn = new JButton("cancel");
        usernameLabel = new JLabel("username");
        passwordLabel = new JLabel("password");


        usernameLabel.setBounds(10, 30, 60, 20);
        passwordLabel.setBounds(10, 90, 60, 20);
        nameTF.setBounds(78, 20, 300, 40);
        psdPF.setBounds(78, 80, 300, 40);
        registerBtn.setBounds(78, 140, 90, 40);
        cancelBtn.setBounds(180, 140, 90, 40);

        getRootPane().setDefaultButton(registerBtn);
        passwordLabel.requestFocus();

        this.add(nameTF);
        this.add(psdPF);
        this.add(registerBtn);
        this.add(cancelBtn);
        this.add(usernameLabel);
        this.add(passwordLabel);
    }

    private void addEvent() {
        registerBtn.addActionListener(this);
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        DataPackage dataPackage = new DataPackage(nameTF.getText(), null, DataPackage.MessageType.REGISTER, psdPF.getText());
        if(registerAction == null){
            showServerErrorDialog();
        }else {
            registerAction.sendDataPackage(dataPackage);
        }
    }

    public void showErrorDialog(){
        JOptionPane.showMessageDialog(null, "registration error");
    }

    private void showServerErrorDialog(){
        JOptionPane.showMessageDialog(null, "server error");
    }

    public void showSuccessDialog(){
        JOptionPane.showMessageDialog(null, "registration success");
        this.dispose();
        new Thread(new LoginFrame()).start();
    }

    @Override
    public void run() {
        flag = registerAction != null;
        while (flag) {
            DataPackage dataPackage = registerAction.receiveDataPackage();
            registerAction.handleDataPackage(dataPackage);
        }
    }

    public static void main(String[] args) {
        new Thread(new RegisterFrame()).start();
    }

}
