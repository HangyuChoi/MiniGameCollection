package minigame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mole_GamePanel extends JFrame {
	JPanel panelGame, panelButton;
	JButton[] button;
	JButton button0;
	JLabel label_e; 
	String[] path; 
	public ImageIcon icon;
	String path1;
	public Mole_GamePanel() {
		setLayout(new BorderLayout());
		 path = new String[8];	// image path
	     path1 = "img/NoMole.png";
	     path[1] = "img/NormalMole.png";	 
	     path[2] = "img/NormalMoleClicked.png";	
	     path[3] = "img/GoldHairMole.png";
	     path[4] = "img/GoldHairMoleClicked.png";
	     path[5] = "img/MinusMouse.png";
	     path[6] = "img/MinusMouseClicked.png";
	     path[7] = "img/Miss.png";

		button = new JButton[11]; 
		for(int i = 0; i < button.length; i++) {
			if(i == 9 || i == 10) {
				button[i] = new JButton();  
	    	} else {
			button[i] = new JButton();
			button[i].setIcon(new ImageIcon(getClass().getResource(path1)));
			button[i].setDisabledIcon(icon);
			button[i].setBorderPainted(false); 
			button[i].setFocusPainted(false);
			button[i].setFocusable(false);
			button[i].setOpaque(false);
	    	}
		}
		button0 = new JButton();
		button0.setIcon(new ImageIcon(getClass().getResource(path1)));
		button0.setDisabledIcon(icon);
		button0.setBorderPainted(false); 
		button0.setFocusPainted(false);
		button0.setFocusable(false);
		button0.setOpaque(false);
		
		button0.setName("90");
		
		button[9].setText("NEW START");
		button[9].setEnabled(false);
		button[10].setText("BACK");
  
		label_e = new JLabel();
		
		
		panelGame = new JPanel(new GridLayout(3,3));
		for(int i = 0; i < 9; i++){
			panelGame.add(button[i]);
		}
		
		
		panelButton = new JPanel(new FlowLayout());
		panelButton.add(button[9]);
		panelButton.add(label_e);
		panelButton.add(button[10]);
		
		
		add(panelButton, "North");
		add(panelGame);
		setSize(640,640);
	}
}
