package sugangSincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EConfiguration;
import constants.Constants.EDirecory;
import control.CDirectory;
import sugangSincheong.PContentPanel.ListSelectionHandler;
import valueObject.VDirectory;

public class PHakgwaSelection extends JPanel {
	private static final long serialVersionUID = 1L;

	private String fileName;
	
	private PDirectory pCampus;
	private PDirectory pCollege;
	private PDirectory pHakgwa;
	

	public PHakgwaSelection(ListSelectionListener listSelectionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.fileName = EConfiguration.rootFileName.getText();
		
		
		JScrollPane scrollpane;
		scrollpane = new JScrollPane();
		this.pCampus = new PDirectory(EDirecory.campus.getText(), listSelectionHandler);
		scrollpane.setViewportView(this.pCampus);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pCollege = new PDirectory(EDirecory.college.getText(), listSelectionHandler);
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pHakgwa = new PDirectory(EDirecory.hakgwa.getText(), listSelectionHandler);
		scrollpane.setViewportView(this.pHakgwa);
		this.add(scrollpane);	

	}
	
	public void initialize() {
		fileName = this.pCampus.initialize(fileName);
		fileName = this.pCollege.initialize(fileName);
		fileName = this.pHakgwa.initialize(fileName);				
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public String update(Object source) {

		if (source.equals(this.pCampus.getSelectionModel())) {
			
			this.fileName = this.pCampus.getSelectedFileName();			
			this.fileName = this.pCollege.getData(this.fileName);
			this.fileName = this.pHakgwa.getData(this.fileName);
			
		} else if (source.equals(this.pCollege.getSelectionModel())) {
																
			this.fileName = this.pCollege.getSelectedFileName();
			this.fileName = this.pHakgwa.getData(this.fileName);
			
		} else if (source.equals(this.pHakgwa.getSelectionModel())) {
			
			this.fileName = this.pHakgwa.getSelectedFileName();
		}
		
		return this.fileName;
		
	}
	
	class PDirectory extends JTable {
		private static final long serialVersionUID = 1L;

		private DefaultTableModel tableModel;
		
		private ListSelectionListener listSelectionHandler;
		private Vector<String> header;
		private Vector<VDirectory> vDirectories;
		private CDirectory cDirectory;
		
		
		public PDirectory(String title, ListSelectionListener listSelectionHandler) {
			// attributes
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.listSelectionHandler = listSelectionHandler;
			this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
			
			
			// data model
			header = new Vector<String>();
			header.addElement(title);
			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);
			
		}

		public String initialize(String fileName) {
			return this.getData(fileName);			
		}
		
		
		public String getSelectedFileName() {
			int selectedIndex = this.getSelectedRow();
			if(selectedIndex >= 0) {
				String selectedFileName = this.vDirectories.get(selectedIndex).getFileName();
				return selectedFileName;
			}
			return null;
		}

		public String getData(String fileName) {
			this.getSelectionModel().removeListSelectionListener(this.listSelectionHandler);
			
			// tablemodel의 rowCount를 0으로 만들어서 초괴화를 한다.
			this.tableModel.setRowCount(0);
			
			cDirectory = new CDirectory();
			this.vDirectories = cDirectory.getData(fileName);
			for (VDirectory vDirectory: this.vDirectories) {
				Vector<String> row = new Vector<String>();
				row.add(vDirectory.getName());
				this.tableModel.addRow(row);
			}
			
			String selectedFileName = null;
			if (vDirectories.size() > 0) {
				this.getSelectionModel().addSelectionInterval(0, 0);
				selectedFileName = vDirectories.get(0).getFileName();
			}
			
			this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
			return selectedFileName;
		}
		
		public Vector<VDirectory> getDirectory() {
			return this.vDirectories;
		}

	}
	
}




