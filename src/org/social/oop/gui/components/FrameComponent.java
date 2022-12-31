package org.social.oop.gui.components;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class FrameComponent extends JFrame{
	
	public FrameComponent() {
		super();
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setBounds(250,250,0,0);
		this.setSize(500,400);
		this.setVisible(true);
	}
}
