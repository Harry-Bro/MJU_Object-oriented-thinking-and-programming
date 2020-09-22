package sugangSincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class PDirectory extends JTable {

	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel tableModel;
	private Vector<String> data;

	public PDirectory(String title, Vector<String> rowData) {
		// attributes
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// data model
		Vector<String> header = new Vector<String>();
		header.addElement(title);
		
		this.tableModel = new DefaultTableModel(header, 0);
		// addRow() 메소드는 첫 인덱스부터 columNames의 개수만큼만 추가되기 때문에 Vector를 초기화
		addRowData(rowData);
		
		this.setModel(this.tableModel);
	}
	
	void addRowData(Vector<String> rowData) {
		for(int i=0; i<rowData.size(); i++) {
			data = new Vector<>();
			data.add(rowData.get(i));
			tableModel.addRow(data);	
		}
	}
	
}
