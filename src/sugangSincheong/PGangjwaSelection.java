package sugangSincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PGangjwaSelection extends JTable {

	private static final long serialVersionUID = 1L;
	
	public PGangjwaSelection() {
		
		Vector<String> header = new Vector<String>();
		
		header.addElement("강좌번호 ");
		header.addElement("강좌명 ");
		header.addElement("담당교수");
		header.addElement("시간 ");
		
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		this.setModel(tableModel);
		
		
	}
	
}
