package minigame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mole_StageSelect extends Frame implements ActionListener {
public JPanel moleLevelPanel, moleLevelPanelButton, moleLevelMainPanel;
	
	JButton moleEasyBtn = new JButton();
	JButton moleNormalBtn = new JButton();
	JButton moleHardBtn = new JButton();
	JButton moleBackBtn = new JButton("BACK");
	
	JLabel[] label;
	JLabel label_State, label1;

	Mole_InfoLookup lookup;
	
	public Mole_StageSelect() {	
		lookup = new Mole_InfoLookup();
		lookup.setVisible(false);

		label_State = new JLabel("Select Stage");
		label1 = new JLabel("                                                                                                                                    ");

		moleLevelPanelButton = new JPanel(new FlowLayout());
		moleLevelPanelButton.add(label_State);
		moleLevelPanelButton.add(label1);
		moleLevelPanelButton.add(moleBackBtn);
		
		moleEasyBtn.setIcon(new ImageIcon("src/minigame/img/Mole_Easy.png"));
		moleNormalBtn.setIcon(new ImageIcon("src/minigame/img/Mole_Normal.png"));
		moleHardBtn.setIcon(new ImageIcon("src/minigame/img/Mole_Hard.png"));
		moleEasyBtn.setBounds(50, 20, 540, 160);
		moleNormalBtn.setBounds(50, 200, 540, 160);
		moleHardBtn.setBounds(50, 380, 540, 160);

		
		moleEasyBtn.setBorderPainted(false);
		moleHardBtn.setBorderPainted(false);
		moleNormalBtn.setBorderPainted(false);
		
		moleLevelPanel = new JPanel();
		moleLevelPanel.setLayout(null);
		moleLevelPanel.setBackground(Color.WHITE);
		moleLevelPanel.add(moleEasyBtn);
		moleLevelPanel.add(moleNormalBtn);
		moleLevelPanel.add(moleHardBtn);
		
		moleLevelMainPanel = new JPanel(new BorderLayout());
		moleLevelMainPanel.add(moleLevelPanelButton, "North");
		moleLevelMainPanel.add(moleLevelPanel);

		add(moleLevelMainPanel); 			

		setSize(640, 640);
		
		moleEasyBtn.addActionListener(this);
		moleNormalBtn.addActionListener(this);
		moleHardBtn.addActionListener(this);
		moleBackBtn.addActionListener(this);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// BACK
		if (obj == moleBackBtn) {
			Main m = new Main();
			m.setVisible(true);
			setVisible(false);
			
		}
		// Mole Catching - Easy
		else if ( obj == moleEasyBtn) {
			Mole_Easy easyMole = new Mole_Easy();
			easyMole.setVisible(true);
			setVisible(false);	
		}
		
		// Mole Catching - Normal
		else if ( obj == moleNormalBtn) {
			Mole_Normal normalMole = new Mole_Normal();
			normalMole.setVisible(true);
			setVisible(false);
		}
		
		// Mole Catching - Hard
		else if ( obj == moleHardBtn) {
			Mole_Hard hardMole = new Mole_Hard();
			hardMole.setVisible(true);
			setVisible(false);
		}
	}
}
