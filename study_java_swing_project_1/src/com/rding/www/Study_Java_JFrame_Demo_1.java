package com.rding.www;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Study_Java_JFrame_Demo_1{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Wecom To Gobang");
		
		frame.setSize(640, 640);
		frame.setLocation(100, 100);
		frame.setBackground(Color.BLACK);
//		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setResizable(false);	// 禁止调整窗口大小
		
		study_java_JPanel_demo_1 myJPanel = new study_java_JPanel_demo_1();
		frame.add(myJPanel);
		
		myJPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int c = e.getButton();
				if(c == MouseEvent.BUTTON1) {
					myJPanel.click_left(e.getX(), e.getY());
				}else if(c == MouseEvent.BUTTON3) {
					myJPanel.click_right();
				}
//				System.out.println("鼠标点击了：x = " + e.getX() + ", y = " + e.getY());
			}
		});
		
//		Thread panelThread = new Thread(myJPanel);
//		panelThread.start();
	}
}
