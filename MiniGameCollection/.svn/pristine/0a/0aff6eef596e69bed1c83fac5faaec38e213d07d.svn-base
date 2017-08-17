package minigame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PairGame extends JFrame implements ActionListener {
	
	public int level;			// 게임 난이도 설정

	JPanel pairMainPanel;		// 메인 패널
	JPanel pairLevelPanel;		// 레벨 패널
	JPanel levelNorthPanel;		//난이도 선택 상단 패널
	JPanel levelCenterPanel;	// 난이도 선택 센터 패널	
	
	// 게임 상단 화면 설정
	JLabel levelLabel = new JLabel("난이도 선택");
	JLabel blankLabel = new JLabel("                                                                                                                   ");
	JButton backBtn = new JButton("메인으로");

	// 난이도 선택 버튼
	JButton easyBtn = new JButton();
	JButton normalBtn = new JButton();
	JButton hardBtn = new JButton();
	
	Color color = new Color(254,205,207);
	
	//생성자
	public PairGame() {
		levelSelect();
	}

	public void levelSelect() {
		pairLevelPanel = new JPanel();	// 메인 패널
		pairLevelPanel.setLayout(new BorderLayout());
		pairLevelPanel.setBackground(Color.BLACK);

		// 난이도 선택 상단 패널
		JPanel levelNorthPanel = new JPanel();
		pairLevelPanel.add(levelNorthPanel, BorderLayout.NORTH);
		levelNorthPanel.setLayout(new FlowLayout());
		
		levelNorthPanel.add(levelLabel);
		levelNorthPanel.add(blankLabel);
		levelNorthPanel.add(backBtn);
		
		// 난이도 선택 센터 패널
		JPanel levelCenterPanel = new JPanel();
		pairLevelPanel.add(levelCenterPanel, BorderLayout.CENTER);
		levelCenterPanel.setLayout(null);
			
		easyBtn.setBounds(50, 20, 530, 160);
		normalBtn.setBounds(50, 200, 530, 160);
		hardBtn.setBounds(50, 380, 530, 160);

		easyBtn.setIcon(new ImageIcon("src/images/pair_easy.png"));
		normalBtn.setIcon(new ImageIcon("src/images/pair_normal.png"));
		hardBtn.setIcon(new ImageIcon("src/images/pair_hard.png"));

		levelCenterPanel.add(easyBtn);
		levelCenterPanel.add(normalBtn);
		levelCenterPanel.add(hardBtn);

		add(pairLevelPanel);
		setSize(640, 640);
		setBackground(color);
		setVisible(true);
		
		// 난이도 선택 버튼 이벤트 등록
		backBtn.addActionListener(this);
		easyBtn.addActionListener(this);
		normalBtn.addActionListener(this);
		hardBtn.addActionListener(this);
			
		// 윈도우 창 닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 액션
		JButton clickBtn = (JButton) e.getSource();
		if (clickBtn.equals(easyBtn)) {				// 이지 난이도 버튼
			level = 4;
			dispose();
			new PairEasy();
		} else if (clickBtn.equals(normalBtn)) {	// 노멀 난이도 버튼
			System.out.println("normal");
		} else if (clickBtn.equals(hardBtn)) {		// 하드 난이도 버튼
			System.out.println("hard");
		} else if (clickBtn.equals(backBtn)) {		// 새로하기 버튼
			System.out.println("back");
		}
	}
	
	// 메인 실행
	public static void main(String[] args) {
		new PairGame();
	}
	
	/*
	// 이지 패널
	JPanel easyNorthPanel = new JPanel();
	easyPanel.add(easyNorthPanel, BorderLayout.NORTH);
	easyNorthPanel.setLayout(new FlowLayout());
	
	easyNorthPanel.add(resetBtn);
	easyNorthPanel.add(blankLabel);
	easyNorthPanel.add(backBtn);
	
	JPanel easyCenterPanel = new JPanel();
	easyPanel.add(easyCenterPanel, BorderLayout.CENTER);
	easyCenterPanel.setLayout(new GridLayout(EASY, EASY));
	
	for (int i=0; i < easyBtns.length; i++) {
		easyBtns[i] = new JButton();
		randNums[i] = null;
	}
	
	cardsShuffle();
	
	for (int i=0; i < easyBtns.length; i++) {
		easyCenterPanel.add(easyBtns[i]);
		easyBtns[i].addActionListener(this);
	}
	
	// 노멀 패널
	JPanel normalNorthPanel = new JPanel();
	normalPanel.add(normalNorthPanel, BorderLayout.NORTH);
	normalNorthPanel.setLayout(new FlowLayout());
	
	normalNorthPanel.add(resetBtn);
	normalNorthPanel.add(blankLabel);
	normalNorthPanel.add(backBtn);
	
	JPanel normalCenterPanel = new JPanel();
	normalPanel.add(normalCenterPanel, BorderLayout.CENTER);
	normalCenterPanel.setLayout(new GridLayout(NORMAL, NORMAL));
	
	for (int i=0; i < NORMAL; i++) {
		for (int j=0; j < NORMAL; j++) {
			normalBtns[i][j] = new JButton();
			normalCenterPanel.add(normalBtns[i][j]);
		}
	}
	
	// 하드 화면
	JPanel hardNorthPanel = new JPanel();
	hardPanel.add(hardNorthPanel, BorderLayout.NORTH);
	hardNorthPanel.setLayout(new FlowLayout());
	
	hardNorthPanel.add(resetBtn);
	hardNorthPanel.add(blankLabel);
	hardNorthPanel.add(backBtn);
	
	JPanel hardCenterPanel = new JPanel();
	hardPanel.add(hardCenterPanel, BorderLayout.CENTER);
	hardCenterPanel.setLayout(new GridLayout(HARD, HARD));
	
	for (int i=0; i < HARD; i++) {
		for (int j=0; j < HARD; j++) {
			hardBtns[i][j] = new JButton();
			hardCenterPanel.add(hardBtns[i][j]);
		}
	}
	*/

}