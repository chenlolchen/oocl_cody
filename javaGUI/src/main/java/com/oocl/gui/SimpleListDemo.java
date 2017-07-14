package com.oocl.gui;

/**
 * Created by CHENCO7 on 7/14/2017.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleListDemo extends JFrame {
    private static final long serialVersionUID = 1L;

    public SimpleListDemo() {
        // 设置框架窗口标题
        super("Swing List Demo");

        String[] data = { "Item one", " Item two", " Item three", " Item four",
                "Item five", " Item six", " Item seven", " Item eight",
                "Item night", " Item ten", " Item elevent", " Item twelve", };

        JList m_SimpleList = new JList(data);
        // 把列表组件放入滚动面板中来实现滚动功能
        JScrollPane ps = new JScrollPane(m_SimpleList);
        getContentPane().add(ps, BorderLayout.CENTER);

        // 显示框架窗口
        setSize(500, 240);
        setVisible(true);
    }

    // 应用程序的入口方法
    public static void main(String args[]) {
        SimpleListDemo frame = new SimpleListDemo();
        // 添加框架窗口的事件监听（监听关闭框架窗口事件）
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // 正常推出Java虚拟机
                System.exit(0);
            }
        });
    }
}
