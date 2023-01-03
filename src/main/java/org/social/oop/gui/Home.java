package main.java.org.social.oop.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import main.org.social.oop.gui.shared.SharedButton;
import main.org.social.oop.gui.shared.SharedFrame;

public class Home extends SharedFrame{
	
	
	private final String IMG_PATH = "src/main/resources/images/logoIfpe.png";
	
	private final String AUTHOR = "Adryan Nascimento Reis";
	private final String SUBJECT = "Object-Oriented Programming";
	private final String PROFESSOR = "Gustavo Nóbrega Martins";
	private final String COURSE = "Internet Systems";
	
	
	private JButton buttonLoginPage;
	private JButton buttonRegisterPage;
	private JPanel panelRouteButtons;
	private JPanel panelPresentation;
	private JLabel labelLogo;
	private GridBagConstraints gbConstraints;
	
	public Home() {
		this.setTitle("OOPSocial/Home");		
		this.createRouteButtons();
		this.presentation();
	}
	
	public void createRouteButtons() {

		
		this.panelRouteButtons = new JPanel();
		this.panelRouteButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.buttonLoginPage = new SharedButton("Sign up");
		this.buttonRegisterPage = new SharedButton("Sign in");
		
		
		
		this.buttonLoginPage.addActionListener(new LoginListener());
		this.buttonRegisterPage.addActionListener(new RegisterListener());
		
		
		this.panelRouteButtons.add(buttonLoginPage);
		this.panelRouteButtons.add(buttonRegisterPage);
		
		this.getContentPane().add(this.panelRouteButtons, 
				BorderLayout.SOUTH);
	}
	
	
	public void presentation()  {
		
		
		
		
		this.panelPresentation = new JPanel();
		this.panelPresentation.setLayout(new GridBagLayout());
		
		
		try {
			
			BufferedImage image = ImageIO.read(new File(IMG_PATH));			
			ImageIcon icon = new ImageIcon(image);
			Image scaleImage = icon.getImage().getScaledInstance(250, 150,Image.SCALE_AREA_AVERAGING);
			icon = new ImageIcon(scaleImage);
			this.labelLogo = new JLabel(icon);		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		this.gbConstraints = new GridBagConstraints();
		this.gbConstraints.anchor = GridBagConstraints.CENTER;
		this.gbConstraints.weightx = 512.0D;
		this.gbConstraints.weighty = 1.0D;
	    
		
	    this.labelLogo.setText(
	    			"<html><body><p>Author: "
	    					+this.AUTHOR+
	    				"</p><br><p>Subject: "
	    					+this.SUBJECT+
	    				"</p><br><p>Course: "
	    					+this.COURSE+
	    				"</p><br><p>Professor: "
	    					+this.PROFESSOR+
	    			"<p/></body></html>");
	     
	    panelPresentation.add(this.labelLogo,this.gbConstraints);
	     
		this.getContentPane().add(this.panelPresentation, FlowLayout.CENTER);
		
	}
	
	public class LoginListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					dispose();
					new Login();
				}
			});
			
		}
		
	}
	
	public class RegisterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
					
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					dispose();
					new Register();
				}
			});
		}
		
	}
}
