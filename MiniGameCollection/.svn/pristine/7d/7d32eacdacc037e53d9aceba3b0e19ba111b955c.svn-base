package minigame;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Mole_Easy extends Frame implements Runnable, ActionListener {
	JLabel[] label;
	public JPanel moleSouthPanel, moleMainPanel, panel1;
	int moleScore;
	int normalMoleRandomNumber; 	// NormalMole RandomNumber
	int goldHairMoleRandomNumber; 	// GoldHairMole RandomNumber
	int minusMouseRandomNumber; 	// MinusMouse RandomNumber

	boolean stateT;	// Thread State
	boolean normalMoleState, goldHairMoleState, minusMouseState;
	Random random;
	Timer timer = null;
	int time;
	Thread thread_EASY;
	Mole_GamePanel mole; // Reference Mole_Catching
	
	public Mole_Easy() {
		mole = new Mole_GamePanel();
		
		normalMoleState = false; 	// Normal Mole Not Clicked State
		goldHairMoleState = false; 	// GoldHair Mole Not Clicked State
		minusMouseState = false;	// Minus Mouse Not Clicked State
		
		stateT = true;	// false : Thread Return
		moleScore = 0; 	// Initial Score : 0
		
		random = new Random();
		thread_EASY = new Thread(this);
		thread_EASY.start(); // thread_EASY START
		System.out.println("New // 쓰레드상태 : "+ thread_EASY.getState() + " 쓰레드 이름 : " + thread_EASY.getName() + " 쓰레드 ID : " + thread_EASY.getId());
		timer = new Timer(1000, this);	// Every Second Action
		timer.start();	// timer START
		
		time = 15;	// Initial Time : 15
	
		label = new JLabel[4];
		for(int i = 0; i < label.length; i++) {
			label[i] = new JLabel("");
		}
		// South Panel Label
		label[0].setText("Timer  :");
		label[1].setText(""+time);
		label[2].setText("Score  :");
		label[3].setText(""+moleScore);
		
		// North - Center Label
		mole.label_e.setText("                           MoleCatching - Stage : Easy                                ");
		
		// MainPanel - South
		moleSouthPanel = new JPanel();
		moleSouthPanel.setLayout(new GridLayout(1,4));
		moleSouthPanel.add(label[0]); // Timer
		moleSouthPanel.add(label[1]); 
		moleSouthPanel.add(label[2]); // Stage
		moleSouthPanel.add(label[3]); 
		
		// MainPanel - Center 
		panel1 = new JPanel(new GridLayout(1,1));
		panel1.add(mole.getRootPane()); // Reference Mole_Catcting.class 
		
		// MainPanel
		moleMainPanel = new JPanel();
		moleMainPanel.setLayout(new BorderLayout());
		moleMainPanel.add(panel1, "Center");
		moleMainPanel.add(moleSouthPanel, "South");	
		
		add(moleMainPanel);
		
		setSize(640, 639);
		
		for(int i = 0; i < 9; i++) {
			mole.button[i].addActionListener(this);
			mole.button[i].setName("");
		}
		mole.button[9].addActionListener(this);
		mole.button[10].addActionListener(this);
	}
	
	// User Information Save Method 
	public void saveMoleInfo(String Name, int MoleScore, String moleLevelSelect) {
		Mole_Information NewMoleInfo = new Mole_Information(Name, MoleScore, moleLevelSelect);
		Mole_InfoLookup.moleArrayInfo.add(NewMoleInfo);
		   for(int i = 0; i < Mole_InfoLookup.moleArrayInfo.size(); i++) {
			   System.out.println("Name : " + Mole_InfoLookup.moleArrayInfo.get(i).getUserName());
			   System.out.println("Score : " + Mole_InfoLookup.moleArrayInfo.get(i).getMoleScore());
			   System.out.println("StageLevel : " + Mole_InfoLookup.moleArrayInfo.get(i).getMoleLevel());
			   System.out.println("--------------------");
		   }
		   JOptionPane.showMessageDialog(this, "Your Information Saved !");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(timer == e.getSource()) {
			time--;
			if(time < 1) { // TimeOver
				label[1].setText("0");
				timer.stop();
				for(int i = 0; i < 9; i++) {
					mole.button[i].setIcon(new ImageIcon(getClass().getResource(mole.path1)));
					mole.button[i].setEnabled(false);
				}
				stateT = false;
				boolean dialogException = true;
				mole.button[9].setEnabled(true);
				while(dialogException) {
					String check = JOptionPane.showInputDialog(null, "등록할 닉네임을 입력 해 주세요.", "점수를 저장하고 친구들과 겨뤄보세요 !", JOptionPane.OK_CANCEL_OPTION);
					if(check == null) {
						System.out.println("Do not save.");
						return;
					} else if(check.trim().length() == 0){ 
						System.out.println("Input Error");
						continue;
					}
					else { 
						dialogException = false;
						
						String checked = Pattern.compile("\\s").matcher(check).replaceAll("");	
						saveMoleInfo(checked, moleScore, "Easy"); 
					}
				} // while(dialogException) end
				
			} // TimeOver end 
			else {
				label[1].setText(""+time);
			}
		}
		
		if(obj == mole.button[9]) { // NEW START BUTTON
			if(!stateT) {	
				stateT = true;
				// 쓰레드 새로 받기
				System.out.println("Old // 쓰레드상태 : "+ thread_EASY.getState() + " 쓰레드 이름 : " + thread_EASY.getName() + " 쓰레드 ID : " + thread_EASY.getId());
				Thread thread_EASY = new Thread(this);	
				thread_EASY.start();
				System.out.println("New // 쓰레드상태 : "+ thread_EASY.getState() + " 쓰레드 이름 : " + thread_EASY.getName() + " 쓰레드 ID : " + thread_EASY.getId());
			}
				for(int i = 0; i < 9; i++) {
					mole.button[i].setEnabled(true);
				}
				mole.button[9].setEnabled(false);
				moleScore = 0;
				label[3].setText(""+moleScore);
				timer.restart();
				time = 15;
				label[1].setText(""+time);

		} else if(obj == mole.button[10]) { // BACK BUTTON
			timer.stop();
			moleScore = 0;
			stateT = false;
			try {
	    		 if(Mole_InfoLookup.moleArrayInfo.size() != 0) {
	    			 String saveMoleName = ""; String saveMoleScore = ""; String saveMoleLevel = "";
	    			 FileWriter fw = new FileWriter(new File("D:/MINIGAME_MOLECATCHING_INFO.txt")); 
	    			 for(int i = 0; i < Mole_InfoLookup.moleArrayInfo.size(); i++) {
	    				 saveMoleName = Mole_InfoLookup.moleArrayInfo.get(i).getUserName();
	    				 saveMoleScore = "|" + Mole_InfoLookup.moleArrayInfo.get(i).getMoleScore();
	    				 saveMoleLevel = "|" + Mole_InfoLookup.moleArrayInfo.get(i).getMoleLevel() + "|";
	    				 fw.write(saveMoleName+saveMoleScore+saveMoleLevel);	// Name, Score, Stage
	    			 }
	    			 fw.close();
	    		 } 
			} catch (IOException e1) { e1.printStackTrace(); }
			Main m = new Main();
			m.setVisible(true);
			setVisible(false);			
		} 
		// CENTER BUTTON`S
		else if(obj == mole.button[0] || obj == mole.button[1] || obj == mole.button[2]
				|| obj == mole.button[3] || obj == mole.button[4] || obj == mole.button[5]
				|| obj == mole.button[6] || obj == mole.button[7] || obj == mole.button[8]) {
			for(int i = 0; i < 9; i++) {
				if(obj == mole.button[i]) {
					if(mole.button[i].getName() == "NormalMole") { 
						if(normalMoleState) { 
							return;
						} else {
							mole.button[i].setIcon(new ImageIcon(getClass().getResource(mole.path[2])));
							mole.button[i].setFocusable(false);
							normalMoleState = true;
						}
					} 
					else if(mole.button[i].getName() == "GoleHairMole") {
						if(goldHairMoleState) {
							return;
						} else {
							mole.button[i].setIcon(new ImageIcon(getClass().getResource(mole.path[4])));
							mole.button[i].setFocusable(false);
							goldHairMoleState = true;
						
						}
					} else if(mole.button[i].getName() == "MinusMouse") {
						if(minusMouseState) {
							return;
						} else {
							mole.button[i].setIcon(new ImageIcon(getClass().getResource(mole.path[6])));
							mole.button[i].setFocusable(false);	
							minusMouseState = true;
						} 
					} // getName() == "MinusMouse" end 	
				} // if end
			} // for end
		} // else if end
	} // action end
	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		int moleCheck_1 = 0; // Old NormalMole
		int moleCheck_2 = 0; // Old GoldHairMole
		int moleCheck_3 = 0; // Old MinusMouse
		
		while (true) {
			if(!stateT) {
				return;
			}
			try {
				normalMoleState = false; 
				goldHairMoleState = false; 
				minusMouseState = false; 
				for(int i = 0; i < 9; i++) {
					mole.button[i].setIcon(new ImageIcon(getClass().getResource(mole.path1)));
					mole.button[i].setName("");
				}
				
				int probability1_1 = 0, probability2_1 = 0;	 
				
				normalMoleRandomNumber = random.nextInt(9);		// New NormalMole
				goldHairMoleRandomNumber = random.nextInt(9); 	// New GoldHairMole
				minusMouseRandomNumber = random.nextInt(9); 	// New MinusMouse
			
				probability1_1 = random.nextInt(4); // GoldHairMole Probability 1/4
				probability2_1 = random.nextInt(6); // MinusMouse Probability 1/6
				
				boolean eS = true;	// RandomNumber overlap Check State
				while(eS) {
					if(normalMoleRandomNumber == moleCheck_1) {
						normalMoleRandomNumber = random.nextInt(9);
					} else if(goldHairMoleRandomNumber == moleCheck_2) {
						goldHairMoleRandomNumber = random.nextInt(9);
					} else if(minusMouseRandomNumber == moleCheck_3) {
						minusMouseRandomNumber = random.nextInt(9);
					} else if(normalMoleRandomNumber == goldHairMoleRandomNumber) {
						goldHairMoleRandomNumber = random.nextInt(9);
					} else if(normalMoleRandomNumber == minusMouseRandomNumber) {
						minusMouseRandomNumber = random.nextInt(9);
					} else if(goldHairMoleRandomNumber == minusMouseRandomNumber) {
						minusMouseRandomNumber = random.nextInt(9);
					} else {
						eS = false;
						for(int i = 0; i < 9; i++) {
							mole.button[i].setIcon(new ImageIcon(getClass().getResource(mole.path1)));
						}
					}
				} // while(eS) end 
				
				mole.button[normalMoleRandomNumber].setName("NormalMole");
				mole.button[normalMoleRandomNumber].setIcon(new ImageIcon(getClass().getResource(mole.path[1])));
				
				// GoldHairMole RandomNumber : 1
				if(probability1_1 == 1) {
					mole.button[goldHairMoleRandomNumber].setName("GoleHairMole");
					mole.button[goldHairMoleRandomNumber].setIcon(new ImageIcon(getClass().getResource(mole.path[3])));
				} else {
					mole.button[goldHairMoleRandomNumber].setName("");
					mole.button[goldHairMoleRandomNumber].setIcon(new ImageIcon(getClass().getResource(mole.path1)));
				}
				
				// MinusMouse RandomNumber : 1	
				if(probability2_1 == 1) {
					mole.button[minusMouseRandomNumber].setName("MinusMouse");
					mole.button[minusMouseRandomNumber].setIcon(new ImageIcon(getClass().getResource(mole.path[5])));
				} else {
					mole.button[minusMouseRandomNumber].setName("");
					mole.button[minusMouseRandomNumber].setIcon(new ImageIcon(getClass().getResource(mole.path1)));
				}

				// Delay one seconds
				Thread.sleep(1000);
					 
				// NormalMole Clicked
				if(normalMoleState) { 
					moleScore += 100;	
					label[3].setText(""+moleScore); 
				}
				
				// GoldHairMole Clicked
				if(goldHairMoleState) { 
					moleScore += 200;
					label[3].setText(""+moleScore);
				}
				
				// MinusMouse Clicked
				if(minusMouseState) { 
					if(moleScore <= 150) {
						moleScore = 0;
						label[3].setText(""+moleScore);
					} else {
						moleScore -= 150;	
						label[3].setText(""+moleScore);
					}
				}
				
				// Compare old and new numbers
				moleCheck_1 = normalMoleRandomNumber; 
				moleCheck_2 = goldHairMoleRandomNumber;
				moleCheck_3 = minusMouseRandomNumber;
		
			 } catch(InterruptedException e) {e.printStackTrace();}
		 }
	}
}
