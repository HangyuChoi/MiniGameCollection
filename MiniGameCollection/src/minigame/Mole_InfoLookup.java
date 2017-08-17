package minigame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Mole_InfoLookup extends Frame implements ActionListener {
	JButton searchBackBtn = new JButton("Back");
	Button btn1, btn2;
	public JScrollPane sPanel, sPanel2;
	public JPanel searchPanel, test1, test2, test3;
	public JTable moleTable, pairTable;
	
	// Main Class에서 사용
	public static DefaultTableModel moleModel;
	public static DefaultTableModel pairModel;
	public static List<Mole_Information> moleArrayInfo;
	
	public Mole_InfoLookup() {
		moleArrayInfo = new ArrayList<>();
		
		Vector<String> Column = new Vector<String>();
		Column.addElement("닉네임"); Column.addElement("점수"); Column.addElement("난이도"); 
			 
		moleModel = new DefaultTableModel(Column, 0){ 
			public boolean isCellEditable(int row, int column){ 
				return false;
			}
		};
		pairModel = new DefaultTableModel(Column, 0){ 
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		moleTable = new JTable(moleModel); 
		pairTable = new JTable(pairModel); 
		  
		btn1 = new Button();
		btn1.setLabel("Mole Catching");
		btn1.setBackground(Color.BLACK);
		btn1.setForeground(Color.WHITE);
		btn1.setFocusable(false);
		
		btn2 = new Button();
		btn2.setLabel("Friends Pair");
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(Color.WHITE);
		btn2.setFocusable(false);
			
		searchPanel = new JPanel();
		searchPanel.setLayout(new GridLayout(1,2));
		moleTable.getTableHeader().setReorderingAllowed(false); 
		moleTable.getTableHeader().setResizingAllowed(false);
		moleTable.setRowHeight(25); 
		moleTable.setShowHorizontalLines(true); 
	  
		pairTable.getTableHeader().setReorderingAllowed(false); 
		pairTable.getTableHeader().setResizingAllowed(false); 
		pairTable.setRowHeight(25);
		pairTable.setShowHorizontalLines(true); 
	  
		sPanel = new JScrollPane(moleTable);
		sPanel2 = new JScrollPane(pairTable);
      
		// Header
		DefaultTableCellRenderer tHeader = (DefaultTableCellRenderer)moleTable.getTableHeader().getDefaultRenderer();
		tHeader.setHorizontalAlignment(SwingConstants.CENTER);
		moleTable.getTableHeader().setDefaultRenderer(tHeader);
      
		DefaultTableCellRenderer tHeader2 = (DefaultTableCellRenderer)pairTable.getTableHeader().getDefaultRenderer();
		tHeader2.setHorizontalAlignment(SwingConstants.CENTER);
		pairTable.getTableHeader().setDefaultRenderer(tHeader2);
		// Column
		DefaultTableCellRenderer tColumn = new DefaultTableCellRenderer();
		tColumn.setHorizontalAlignment(SwingConstants.CENTER);
	    TableColumnModel tColumnModel = moleTable.getColumnModel();
      
	    DefaultTableCellRenderer tColumn2 = new DefaultTableCellRenderer();
	    tColumn2.setHorizontalAlignment(SwingConstants.CENTER);
	    TableColumnModel tColumnModel2 = pairTable.getColumnModel();
      
    
	    for (int i = 0; i < tColumnModel.getColumnCount(); i++) {
	    	tColumnModel.getColumn(i).setCellRenderer(tColumn);
	    	tColumnModel2.getColumn(i).setCellRenderer(tColumn2);
	    }
	    searchPanel.add(sPanel);
	    searchPanel.add(sPanel2);
      
	    test1 = new JPanel(new GridLayout(1,2));
	    test1.add(btn1); test1.add(btn2);
	    test3 = new JPanel(new FlowLayout());
	    test3.add(searchBackBtn);
	    test2 = new JPanel(new BorderLayout());
	    test2.add(test1,"North");
	    test2.add(searchPanel);
	    test2.add(test3, "South");
	    add(test2);
	    searchBackBtn.addActionListener(this);
	    
	    // 테이블에 정보 추가
	    infoList();
	    setSize(640, 640);	      
	}
	
	public static void infoList() {
		Vector<String> moleRow;
		moleModel.getDataVector().clear();
		pairModel.getDataVector().clear();
		for(int i = 0; i < moleArrayInfo.size(); i++) {   
			String Name = moleArrayInfo.get(i).getUserName(); 
			int MoleScore = moleArrayInfo.get(i).getMoleScore(); String MS = String.valueOf(MoleScore);
			String Level = moleArrayInfo.get(i).getMoleLevel();
			moleRow = new Vector<String>(); moleRow.addElement(Name); moleRow.addElement(MS); moleRow.addElement(Level); moleModel.addRow(moleRow);      
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == searchBackBtn) {
			Main m = new Main();
			m.setVisible(true);
			setVisible(false);			
		}		
	}
}
