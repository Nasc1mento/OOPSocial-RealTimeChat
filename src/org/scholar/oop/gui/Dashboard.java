package org.scholar.oop.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Dashboard extends JFrame{
	public Dashboard() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(900,500);
		this.setVisible(true);
	}
}
