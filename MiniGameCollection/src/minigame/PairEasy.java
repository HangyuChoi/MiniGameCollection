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

	int easy = 4; // ���� ���̵� �迭 ����
	int pairTime = 30;
	int pairScore = 0;
	
	JPanel pairGamePanel;
	JPanel easyGamePanel; 	// ���� ���̵� ���� �г�
	JPanel easyNorthPanel; 	// ���� ���̵� ��� �г�
	JPanel easyCenterPanel; // ���� ���̵� ���� �г�
	JPanel easySouthPanel; 	// ���� ���̵� �ϴ� �г�

	JButton[] easyBtns = new JButton[easy * easy]; // ī�� ��ư	
	JButton resetBtn = new JButton("�����ϱ�");
	JLabel easyLabel = new JLabel("          < PAIR GAME > LEVEL: EASY          ");
	JButton backBtn = new JButton("��������");

	JLabel timerLabel = new JLabel("                              TIMER : ");
	JLabel timerCount = new JLabel(Integer.toString(pairTime));
	JLabel scoreLabel = new JLabel("                              SCORE : ");
	JLabel scoreCount = new JLabel(Integer.toString(pairScore));

	int arrRand = 0; // ù ��° ī�� ��ġ ��ġ ������
	int comRand = 0; // �� ��° ī�� ��ġ ��ġ ������
	int imgCount = 0; // �̹��� ���� ī��Ʈ üũ(�� �� ����)
	int pairCount = 0; // ���� ī��Ʈ üũ
	int firstClick = 100; // ù ��° Ŭ�� �迭 ��ġ ��
	
	boolean pairFlag = false; // �̹��� �ߺ� ��ġ ���� �÷���
	boolean clickFlag = false; // ù ��° �� ��° Ŭ�� ���� �÷���
	boolean sameFlag = false;

	String firstCard = null; // ù ��° Ŭ�� �迭 ���ڿ� ��
	String pairRand = null; // ù ��° Ŭ�� �迭 ���ڿ� ��
	String[] randNums = new String[easy * easy]; // ���� ��ư �迭 ��ġ�� ���ڿ� ��

	String path = "src/images/"; // �̹��� �н�
	String ext = ".png"; // �̹��� Ȯ����
	
	Timer pairTimer = null;
	Color color = new Color(250,208,238);
	
	public void run() {
		cardsShuffle();	// ī�� ���� ���� ��ġ

		try {
			Thread.sleep(3000);	// 3�ʰ� ī�� �����ֱ�
		} catch (InterruptedException ie) {
			
		}
		// ī��  �޸����� ������ ��ġ
		for (int i = 0; i < easyBtns.length; i++) {
			easyBtns[i].setIcon(new ImageIcon(path + "pair_back" + ext));
		}
		// ī�� ��ư �̺�Ʈ ���
		for (int i = 0; i < easyBtns.length; i++) {
			easyBtns[i].addActionListener(this);
			easyBtns[i].addMouseListener(this);
		}
	}

	public PairEasy() {
		new Thread(this).start();

		// ���� ȭ�� ��� ��ư �̺�Ʈ ���
		resetBtn.addActionListener(this);
		backBtn.addActionListener(this);

		pairTimer = new Timer(1000, this);
		pairTimer.start();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void cardsShuffle() {
		pairGamePanel = new JPanel();
		pairGamePanel.setLayout(new BorderLayout());

		// ���� ���̵� ��� �г�
		easyNorthPanel = new JPanel();
		pairGamePanel.add(easyNorthPanel, BorderLayout.NORTH);
		easyNorthPanel.setLayout(new FlowLayout());

		easyNorthPanel.add(resetBtn);
		easyNorthPanel.add(easyLabel);
		easyNorthPanel.add(backBtn);

		// ���� ���̵� ���� �г�
		easyCenterPanel = new JPanel();
		pairGamePanel.add(easyCenterPanel, BorderLayout.CENTER);
		easyCenterPanel.setLayout(new GridLayout(easy, easy));

		// ī�� ��ư �迭 ����
		for (int i = 0; i < easyBtns.length; i++) {
			easyBtns[i] = new JButton();
			randNums[i] = null;
		}

		// ī�� �� �־� ������ ��ġ�� �����ϱ�
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

		// ī�� ��ư ���
		for (int i = 0; i < easyBtns.length; i++) {
			// easyBtns[i].setBackground(new Color(255, 210, 0));
			easyCenterPanel.add(easyBtns[i]);
		}

		// ���� ���̵� �ϴ� �г�
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

	// ¦���߱� ���� ��� ����
	public void pairCheck(int num) {
		// ���� ī�带 �ߺ� Ŭ���ϴ� ��츦 ����,
		// ù ��° ī��� �ι� ° ī�� �̹����� ���ڿ� ���� ������ ī�� �̹����� �����Ѵ�.
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
				System.out.println(randNums[num] + "��" + firstCard + "�� ¦�� �¾ҽ��ϴ�.");
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
					System.out.println("�������� Ŭ����!!!");
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
				System.out.println("�ð� �ʰ�");
			} else {
				timerCount.setText(Integer.toString(pairTime));
			}
		}

		if (e.getSource().equals(resetBtn)) { // �����ϱ� ��ư
			dispose();
			new PairEasy();
			System.out.println("reset");
		} else if (e.getSource().equals(backBtn)) { // �������� ��ư
			System.out.println("main");
		} else if (e.getSource().equals(easyBtns[0])) { // ���� ���̵� [0]~[15]��ư
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

	// ���� ����
	public static void main(String[] args) throws Exception {
		new PairEasy();
	}

}
