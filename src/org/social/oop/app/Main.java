package org.social.oop.app;

import javax.swing.SwingUtilities;

import org.social.oop.gui.Home;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Home();
			}
		});
	}
}
