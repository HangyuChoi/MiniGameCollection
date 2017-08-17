package minigame;

import java.awt.Robot;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PairEasy extends JFrame implements ActionListener, MouseListener, Runnable {

	int easy = 4; // 이지 난이도 배열 숫자
	int pairTime = 30;
	int pairScore = 0;
	
	JPanel pairGamePanel;
	JPanel easyGamePanel; 	// 이지 난이도 메인 패널
	JPanel easyNorthPanel; 	// 이지 난이도 상단 패널
	JPanel easyCenterPanel; // 이지 난이도 센터 패널
	JPanel easySouthPanel; 	// 이지 난이도 하단 패널

	JButton[] easyBtns = new JButton[easy * easy]; // 카드 버튼	
	JButton resetBtn = new JButton("새로하기");
	JLabel easyLabel = new JLabel("          < PAIR GAME > LEVEL: EASY          ");
	JButton backBtn = new JButton("메인으로");

	JLabel timerLabel = new JLabel("                              TIMER : ");
	JLabel timerCount = new JLabel(Integer.toString(pairTime));
	JLabel scoreLabel = new JLabel("                              SCORE : ");
	JLabel scoreCount = new JLabel(Integer.toString(pairScore));

	int arrRand = 0; // 첫 번째 카드 배치 위치 랜덤값
	int comRand = 0; // 두 번째 카드 배치 위치 랜덤값
	int imgCount = 0; // 이미지 삽입 카운트 체크(한 쌍 기준)
	int pairCount = 0; // 정답 카운트 체크
	int firstClick = 100; // 첫 번째 클릭 배열 위치 값
	
	boolean pairFlag = false; // 이미지 중복 배치 방지 플래그
	boolean clickFlag = false; // 첫 번째 두 번째 클릭 구별 플래그
	boolean sameFlag = false;

	String firstCard = null; // 첫 번째 클릭 배열 문자열 값
	String pairRand = null; // 첫 번째 클릭 배열 문자열 값
	String[] randNums = new String[easy * easy]; // 랜덤 버튼 배열 위치의 문자열 값

	String path = "src/images/"; // 이미지 패스
	String ext = ".png"; // 이미지 확장자
	
	Timer pairTimer = null;
	Color color = new Color(250,208,238);
	
	public void run() {
		cardsShuffle();	// 카드 섞고 랜덤 배치

		try {
			Thread.sleep(3000);	// 3초간 카드 보여주기
		} catch (InterruptedException ie) {
			
		}
		// 카드  뒷면으로 가리게 배치
		for (int i = 0; i < easyBtns.length; i++) {
			easyBtns[i].setIcon(new ImageIcon(path + "pair_back" + ext));
		}
		// 카드 버튼 이벤트 등록
		for (int i = 0; i < easyBtns.length; i++) {
			easyBtns[i].addActionListener(this);
			easyBtns[i].addMouseListener(this);
		}
	}

	public PairEasy() {
		new Thread(this).start();

		// 이지 화면 상단 버튼 이벤트 등록
		resetBtn.addActionListener(this);
		backBtn.addActionListener(this);

		pairTimer = new Timer(1000, this);
		pairTimer.start();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void cardsShuffle() {
		pairGamePanel = new JPanel();
		pairGamePanel.setLayout(new BorderLayout());

		// 이지 난이도 상단 패널
		easyNorthPanel = new JPanel();
		pairGamePanel.add(easyNorthPanel, BorderLayout.NORTH);
		easyNorthPanel.setLayout(new FlowLayout());

		easyNorthPanel.add(resetBtn);
		easyNorthPanel.add(easyLabel);
		easyNorthPanel.add(backBtn);

		// 이지 난이도 센터 패널
		easyCenterPanel = new JPanel();
		pairGamePanel.add(easyCenterPanel, BorderLayout.CENTER);
		easyCenterPanel.setLayout(new GridLayout(easy, easy));

		// 카드 버튼 배열 생성
		for (int i = 0; i < easyBtns.length; i++) {
			easyBtns[i] = new JButton();
			randNums[i] = null;
		}

		// 카드 한 쌍씩 랜덤한 위치에 설정하기
		while (easyBtns.length / 2 != imgCount) {
			pairRand = String.valueOf((int) (Math.random() * 64));
			for (int i = 0; i < easyBtns.length; i++) {
				if (pairRand.equals(randNums[i])) {
					pairFlag = true;
					// System.out.println(pairFlag);
				}
			}
			if (pairFlag != true) {
				arrRand = (int) (Math.random() * easyBtns.length);
				comRand = (int) (Math.random() * easyBtns.length);
				if ((arrRand != comRand) && (randNums[arrRand] == null) && (randNums[comRand] == null)) {
					randNums[arrRand] = pairRand;
					easyBtns[arrRand].setIcon(new ImageIcon(path + pairRand + ext));
					easyBtns[arrRand].setBackground(color);
					randNums[comRand] = pairRand;
					easyBtns[comRand].setIcon(new ImageIcon(path + pairRand + ext));
					easyBtns[comRand].setBackground(color);
					imgCount++;
				}
			}
			pairFlag = false;
			// System.out.println(pairFlag);
		}

		// 카드 버튼 등록
		for (int i = 0; i < easyBtns.length; i++) {
			// easyBtns[i].setBackground(new Color(255, 210, 0));
			easyCenterPanel.add(easyBtns[i]);
		}

		// 이지 난이도 하단 패널
		easySouthPanel = new JPanel();
		pairGamePanel.add(easySouthPanel, BorderLayout.SOUTH);
		easySouthPanel.setLayout(new GridLayout(1, 4));

		easySouthPanel.add(timerLabel);
		easySouthPanel.add(timerCount);
		easySouthPanel.add(scoreLabel);
		easySouthPanel.add(scoreCount);

		add(pairGamePanel);
		setSize(640, 640);
		setVisible(true);
	}

	// 짝맞추기 게임 기능 구현
	public void pairCheck(int num) {
		// 같은 카드를 중복 클릭하는 경우를 막고,
		// 첫 번째 카드와 두번 째 카드 이미지의 문자열 값이 같으면 카드 이미지를 오픈한다.
		if (num != firstClick) {
			if (randNums[num].equals(firstCard)) {
				easyBtns[firstClick].setIcon(new ImageIcon(path + firstCard + ext));
				easyBtns[num].setIcon(new ImageIcon(path + randNums[num] + ext));
				easyBtns[firstClick].removeActionListener(this);
				easyBtns[firstClick].removeMouseListener(this);
				easyBtns[num].removeActionListener(this);
				easyBtns[num].removeMouseListener(this);
				easyLabel.setText("          < 2ND CARD > LEVEL: EASY          ");
				System.out.println("secondCard = " + randNums[num]);
				System.out.println(randNums[num] + "과" + firstCard + "의 짝이 맞았습니다.");
				firstCard = null;
				clickFlag = false;
				sameFlag = true;
				pairCount++;
				pairScore = pairScore + ((1000 * easy) / pairCount);
				scoreCount.setText(Integer.toString(pairScore));
				System.out.println("pairCount = " + pairCount);
				if (pairCount == easyBtns.length / 2) {
					pairScore = pairScore + (pairTime * easy * 100);
					scoreCount.setText(Integer.toString(pairScore));
					pairTimer.stop();
					System.out.println("스테이지 클리어!!!");
				}
			} else {
				sameFlag = false;
				if (!clickFlag) {
					firstClick = num;
					firstCard = randNums[num];
					easyLabel.setText("          < 2ND CARD > LEVEL: EASY          ");
					System.out.println("firstCard = " + randNums[num]);
					clickFlag = true;

				} else {
					easyLabel.setText("          < 1ST CARD > LEVEL: EASY          ");
					System.out.println("secondCard = " + randNums[num]);
					firstCard = null;
					clickFlag = false;
					if (pairScore > 0) {
						if ((pairScore - ((100 * easy) * pairCount)) > 0) {
							pairScore = pairScore - ((100 * easy) * pairCount);
						} else {
							pairScore = 0;
						}
					}
					scoreCount.setText(Integer.toString(pairScore));
				}
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == pairTimer) {
			pairTime--;
			if (pairTime < 11) {
				timerLabel.setForeground(Color.RED);
				timerCount.setForeground(Color.RED);
			}
			if (pairTime < 1) {
				timerCount.setText("0");
				pairTimer.stop();
				System.out.println("시간 초과");
			} else {
				timerCount.setText(Integer.toString(pairTime));
			}
		}

		if (e.getSource().equals(resetBtn)) { // 새로하기 버튼
			dispose();
			new PairEasy();
			System.out.println("reset");
		} else if (e.getSource().equals(backBtn)) { // 메인으로 버튼
			System.out.println("main");
		} else if (e.getSource().equals(easyBtns[0])) { // 이지 난이도 [0]~[15]버튼
			pairCheck(0);
		} else if (e.getSource().equals(easyBtns[1])) {
			pairCheck(1);
		} else if (e.getSource().equals(easyBtns[2])) {
			pairCheck(2);
		} else if (e.getSource().equals(easyBtns[3])) {
			pairCheck(3);
		} else if (e.getSource().equals(easyBtns[4])) {
			pairCheck(4);
		} else if (e.getSource().equals(easyBtns[5])) {
			pairCheck(5);
		} else if (e.getSource().equals(easyBtns[6])) {
			pairCheck(6);
		} else if (e.getSource().equals(easyBtns[7])) {
			pairCheck(7);
		} else if (e.getSource().equals(easyBtns[8])) {
			pairCheck(8);
		} else if (e.getSource().equals(easyBtns[9])) {
			pairCheck(9);
		} else if (e.getSource().equals(easyBtns[10])) {
			pairCheck(10);
		} else if (e.getSource().equals(easyBtns[11])) {
			pairCheck(11);
		} else if (e.getSource().equals(easyBtns[12])) {
			pairCheck(12);
		} else if (e.getSource().equals(easyBtns[13])) {
			pairCheck(13);
		} else if (e.getSource().equals(easyBtns[14])) {
			pairCheck(14);
		} else if (e.getSource().equals(easyBtns[15])) {
			pairCheck(15);
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		JButton pressBtn = (JButton) e.getSource();

		for (int i = 0; i < easyBtns.length; i++) {
			if (easyBtns[i] == pressBtn) {
				easyBtns[i].setIcon(new ImageIcon(path + randNums[i] + ext));
				//easyBtns[i].setBackground(color);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JButton releaseBtn = (JButton) e.getSource();

		if (!sameFlag) {
			releaseBtn.setIcon(new ImageIcon(path + "pair_back" + ext));
		}
	}

	// 메인 실행
	public static void main(String[] args) throws Exception {
		new PairEasy();
	}

}
