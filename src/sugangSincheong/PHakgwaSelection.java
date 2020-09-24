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
		rowCampusData.addElement("�ι� ķ�۽�");
		rowCampusData.addElement("�ڿ� ķ�۽�");
		this.pCampus = new PDirectory("ķ�۽�");
		scrollpane.setViewportView(this.pCampus);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		Vector<String> rowCollegeData = new Vector<>();
		rowCollegeData.addElement("�濵����");
		rowCollegeData.addElement("�ι�����");
		rowCollegeData.addElement("ICT����");
		this.pCollege = new PDirectory("����");
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		Vector<String> rowHakgwaData = new Vector<>();
		rowHakgwaData.addElement("�濵�а�");
		rowHakgwaData.addElement("�濵�����а�");
		rowHakgwaData.addElement("�����а�");
		this.pHakgwa = new PDirectory("�а�");
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
