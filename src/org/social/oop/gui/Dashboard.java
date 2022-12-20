package org.social.oop.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Dashboard extends JFrame{
	public Dashboard() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(900, 500);
		this.setLayout(new BorderLayout());
		this.setTitle("OOPSocial/Dashboard");
		this.setBounds(250,250,0,0);
		this.setResizable(false);
		this.setVisible(true);
	}
}
