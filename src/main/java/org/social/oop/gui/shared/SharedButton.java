package main.java.org.social.oop.gui.shared;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SharedButton extends JButton{
	
	private Border line;
	private Border margin;
	private Border compound;
	
	public SharedButton(String text) {
		super(text);
		
		this.line = new LineBorder(null);
		this.margin = new EmptyBorder(5, 15, 5, 15);
		this.compound = new CompoundBorder(line, margin);
		
		this.setForeground(Color.white);
		
		this.setBackground(new Color(59, 130, 246));
		this.setFont(new Font("Serif", Font.BOLD, 14));
		this.setBorder(compound);
		
		
	}
}
