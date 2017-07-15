package com.oocl.chat_room.ui;

import com.oocl.chat_room.pojo.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener{
		private JTextField nameTF;
		private JPasswordField psdPF;
		private JButton loginBtn;
		private JButton cancelBtn;
		private JLabel usernameLabel;
		private JLabel passwordLabel;

		public LoginFrame(){
			this.setSize(400,260);
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


			usernameLabel.setBounds(10,30,60,20);
			passwordLabel.setBounds(10,90,60,20);
			nameTF.setBounds(78,20,300,40);
			psdPF.setBounds(78,80,300,40);
			loginBtn.setBounds(78, 140, 90, 40);
			cancelBtn.setBounds(180,140,90,40);

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
			User user = new User(nameTF.getText());
			this.dispose();
			new Thread(new ChatFrame(user)).start();
		}

}
