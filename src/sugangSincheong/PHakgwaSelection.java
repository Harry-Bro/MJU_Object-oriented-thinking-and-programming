package sugangSincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CDirectory;
import sugangSincheong.PSelection.ListSelectionHandler;
import valueObject.VDirectory;

public class PHakgwaSelection extends JPanel {
	private static final long serialVersionUID = 1L;

	private PDirectory pCampus;
	private PDirectory pCollege;
	private PDirectory pHakgwa;
	
	private String fileName;
	
	public PHakgwaSelection(ListSelectionHandler listSelectionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.fileName = "root";
		
		JScrollPane scrollpane;
		scrollpane = new JScrollPane();
		this.pCampus = new PDirectory("Ä·ÆÛ½º", listSelectionHandler);
		scrollpane.setViewportView(this.pCampus);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pCollege = new PDirectory("´ëÈø", listSelectionHandler);
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pHakgwa = new PDirectory("ÇÐ°ú", listSelectionHandler);
		scrollpane.setViewportView(this.pHakgwa);
		this.add(scrollpane);	

	}
	public void initialize() {
		fileName = this.pCampus.initialize(fileName);
		fileName = this.pCollege.initialize(fileName);
		fileName = this.pHakgwa.initialize(fileName);		
	}
	
	public void update(Object source) {
		if (source.equals(this.pCampus.getSelectionModel())) {
			int selectedRowIndex = this.pCampus.getSelectedRow();
			
			fileName = this.pCollege.getData(fileName);
			fileName = this.pHakgwa.getData(fileName);		
		} else if (source.equals(this.pCollege.getSelectionModel())) {
			
		} else if (source.equals(this.pHakgwa.getSelectionModel())) {
			
		}		
	}
	
	private class PDirectory extends JTable {
		private static final long serialVersionUID = 1L;

		private DefaultTableModel tableModel;
		public PDirectory(String title, ListSelectionHandler listSelectionHandler) {
			// attributes
			this.getSelectionModel().addListSelectionListener(listSelectionHandler);
			
			// data model
			Vector<String> header = new Vector<String>();
			header.addElement(title);
			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);
		}

		public String initialize(String fileName) {
			return this.getData(fileName);			
		}

		public String getData(String fileName) {
			CDirectory cDirectory = new CDirectory();
			Vector<VDirectory> vDirectories = cDirectory.getData(fileName);
			for (VDirectory vDirectory: vDirectories) {
				Vector<String> row = new Vector<String>();
				row.add(vDirectory.getName());
				this.tableModel.addRow(row);
			}
			if (vDirectories.size() > 0) {
				this.getSelectionModel().addSelectionInterval(0, 0);
				return vDirectories.get(0).getFileName();
			}
			return null;
		}
	}
}


















