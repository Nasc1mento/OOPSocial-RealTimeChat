package org.scholar.oop.app;

import javax.swing.SwingUtilities;

import org.scholar.oop.gui.Home;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Home home = new Home();
			}
		});
	}
}
