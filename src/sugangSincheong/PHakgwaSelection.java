package sugangSincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PHakgwaSelection extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private PDirectory pCampus;
	private PDirectory pCollege;
	private PDirectory pHakgwa;
	private PDirectory pGangjwa;
	
	
	public PHakgwaSelection() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane scrollpane;
		
		scrollpane = new JScrollPane();
		Vector<String> rowCampusData = new Vector<>();
		rowCampusData.addElement("인문 캠퍼스");
		rowCampusData.addElement("자연 캠퍼스");
		this.pCampus = new PDirectory("캠퍼스");
		scrollpane.setViewportView(this.pCampus);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		Vector<String> rowCollegeData = new Vector<>();
		rowCollegeData.addElement("경영대학");
		rowCollegeData.addElement("인문대학");
		rowCollegeData.addElement("ICT대학");
		this.pCollege = new PDirectory("대학");
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		Vector<String> rowHakgwaData = new Vector<>();
		rowHakgwaData.addElement("경영학과");
		rowHakgwaData.addElement("경영정보학과");
		rowHakgwaData.addElement("행정학과");
		this.pHakgwa = new PDirectory("학과");
		scrollpane.setViewportView(this.pHakgwa);
		this.add(scrollpane);
	}

	private class PDirectory extends JTable {
		private DefaultTableModel tableModel;
		
		public PDirectory(String title) {
			Vector<String> header = new Vector<String>();
			header.addElement(title);
			header.addElement(title);
			
//			Object[][] data = {
//					{1,2},
//					{3,4}
//			};
			
			this.tableModel = new DefaultTableModel(header, 0);
			
//			this.tableModel.addRow(data[0]);
//			this.tableModel.addRow(data[1]);
			
			this.setModel(this.tableModel);
			
		}
	}
	
}
