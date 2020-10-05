package sugangSincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class PDirectory extends JTable {
	private static final long serialVersionUID = 1L;

	private DefaultTableModel tableModel;
	public PDirectory(String title) {
		// attributes
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// data model
		Vector<String> header = new Vector<String>();
		header.addElement(title);
		
		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(this.tableModel);
//		this.getSelectionModel().addListSelectionListener(ListSelectionHandler);
	}
}
