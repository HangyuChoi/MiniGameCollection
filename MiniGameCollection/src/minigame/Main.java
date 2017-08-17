package minigame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Main extends Frame implements ActionListener{

	JPanel panelMain;
	JButton[] btn;
	Mole_StageSelect moleStage;
	
	public Main(){
		moleStage = new Mole_StageSelect();
		moleStage.setVisible(false);
	
		// Main Panel
	    panelMain = new JPanel();
	    panelMain.setLayout(null);
	    panelMain.setBackground(Color.WHITE);
	    
	    // Main Button
	    btn = new JButton[4];
	    // Mole
	    btn[0] = new JButton();    
	    btn[0].setBounds(50, 40, 240, 400);
	    btn[0].setIcon(new ImageIcon("src/minigame/img/MoleStartBtn.png"));
	
	    // Card
	    btn[1] = new JButton();    
	    btn[1].setBounds(340, 40, 240, 400);
	    btn[1].setIcon(new ImageIcon("src/minigame/img/pair_start.png"));
	   
	    // Lookup
	    btn[2] = new JButton(new ImageIcon("src/minigame/img/Lookup.png"));
	    btn[2].setBounds(50, 470, 240, 100);
	    
	    // Exit
	    btn[3] = new JButton(new ImageIcon("src/minigame/img/EXIT.png"));
	    btn[3].setBounds(340, 470, 240, 100);
	    panelMain.add(btn[0]);
	    panelMain.add(btn[1]);
	    panelMain.add(btn[2]);
	    panelMain.add(btn[3]);
	    add(panelMain);
	    
	    
	    btn[0].addActionListener(this);
	    btn[1].addActionListener(this);
	    btn[2].addActionListener(this);
	    btn[3].addActionListener(this);
	    
	    setSize(640, 640);
	    setVisible(true);
	}
	
	public static void main(String args[]) {
		new Main();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btn[0]) { // 두더지 잡기
			setVisible(false);
			moleStage.setVisible(true);
		} else if (obj == btn[1]) {
			// 카드 짝 맞추기 연결해야함
		} else if (obj == btn[2]) { // 정보조회
			String addMoleName = ""; String addMoleScore; String addMoleLevel = ""; 
		    String str = ""; int addMoleScore2;
		    try {
		    	FileReader freader = new FileReader(new File("D:/MINIGAME_MOLECATCHING_INFO.txt"));
		    	while(freader.ready()){
		    		char ch = (char) freader.read();
		    		str = str + ch;
		    	}
		    	freader.close();
		    } catch (IOException e1) { e1.printStackTrace(); } 
		    StringTokenizer st = new StringTokenizer(str, "|");
		    while(st.hasMoreTokens()) {
		    	addMoleName = st.nextToken();
		    	System.out.println("UserName : "+ addMoleName + " Add Ok");
		    	addMoleScore = st.nextToken();
		    	addMoleScore2 = Integer.parseInt(addMoleScore);
		    	addMoleLevel = st.nextToken();  
		    	Mole_Information newAccount = new Mole_Information(addMoleName, addMoleScore2, addMoleLevel);
		    	Mole_InfoLookup.moleArrayInfo.add(newAccount);
		    }
			setVisible(false);
			Mole_InfoLookup.infoList();
			moleStage.lookup.setVisible(true);
		} else if (obj == btn[3]) { // 프로그램 종료
			System.exit(0);
		}
	}  
}
