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
	
	public int level;			// ���� ���̵� ����

	JPanel pairMainPanel;		// ���� �г�
	JPanel pairLevelPanel;		// ���� �г�
	JPanel levelNorthPanel;		//���̵� ���� ��� �г�
	JPanel levelCenterPanel;	// ���̵� ���� ���� �г�	
	
	// ���� ��� ȭ�� ����
	JLabel levelLabel = new JLabel("���̵� ����");
	JLabel blankLabel = new JLabel("                                                                                                                   ");
	JButton backBtn = new JButton("��������");

	// ���̵� ���� ��ư
	JButton easyBtn = new JButton();
	JButton normalBtn = new JButton();
	JButton hardBtn = new JButton();
	
	Color color = new Color(254,205,207);
	
	//������
	public PairGame() {
		levelSelect();
	}

	public void levelSelect() {
		pairLevelPanel = new JPanel();	// ���� �г�
		pairLevelPanel.setLayout(new BorderLayout());
		pairLevelPanel.setBackground(Color.BLACK);

		// ���̵� ���� ��� �г�
		JPanel levelNorthPanel = new JPanel();
		pairLevelPanel.add(levelNorthPanel, BorderLayout.NORTH);
		levelNorthPanel.setLayout(new FlowLayout());
		
		levelNorthPanel.add(levelLabel);
		levelNorthPanel.add(blankLabel);
		levelNorthPanel.add(backBtn);
		
		// ���̵� ���� ���� �г�
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
		
		// ���̵� ���� ��ư �̺�Ʈ ���
		backBtn.addActionListener(this);
		easyBtn.addActionListener(this);
		normalBtn.addActionListener(this);
		hardBtn.addActionListener(this);
			
		// ������ â �ݱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// ��ư �׼�
		JButton clickBtn = (JButton) e.getSource();
		if (clickBtn.equals(easyBtn)) {				// ���� ���̵� ��ư
			level = 4;
			dispose();
			new PairEasy();
		} else if (clickBtn.equals(normalBtn)) {	// ��� ���̵� ��ư
			System.out.println("normal");
		} else if (clickBtn.equals(hardBtn)) {		// �ϵ� ���̵� ��ư
			System.out.println("hard");
		} else if (clickBtn.equals(backBtn)) {		// �����ϱ� ��ư
			System.out.println("back");
		}
	}
	
	// ���� ����
	public static void main(String[] args) {
		new PairGame();
	}
	
	/*
	// ���� �г�
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
	
	// ��� �г�
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
	
	// �ϵ� ȭ��
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