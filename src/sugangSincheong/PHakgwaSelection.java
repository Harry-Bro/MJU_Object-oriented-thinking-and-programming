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
	private String campusName;
	private String collegeName;
	private String hakgwaName;
	private String gangjwaNum;
	
	private boolean initialized = false;
	
	private PGangjwaSelection pGangjwaSelection;
	
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
	public void initialize(PGangjwaSelection pGangjwaSelection) {
		fileName = this.pCampus.initialize(fileName);
		fileName = this.pCollege.initialize(fileName);
		fileName = this.pHakgwa.initialize(fileName);		
		
		this.pGangjwaSelection = pGangjwaSelection;
		this.pGangjwaSelection.initialize(fileName);
		initialized = true;
	}
	
	public void update(Object source) {
		System.out.println("hakgwa table click");
		
		if(initialized == true) {
			if (source.equals(this.pCampus.getSelectionModel())) {
				
				int selectedRowIndex = this.pCampus.getSelectedRow();

				if(selectedRowIndex >= 0) {
					Vector<VDirectory> vDirectories = pCampus.getDirectory();
					fileName = vDirectories.get(selectedRowIndex).getFileName();
	
	
					fileName = this.pCollege.initialize(fileName);
					fileName = this.pHakgwa.initialize(fileName);
					this.pGangjwaSelection.initialize(fileName);
				}
				
			} else if (source.equals(this.pCollege.getSelectionModel())) {
				System.out.println("College click");
				
				int selectedRowIndex = this.pCollege.getSelectedRow();
				if(selectedRowIndex >= 0) {
					System.out.println(selectedRowIndex);
					
					Vector<VDirectory> vDirectories = pCollege.getDirectory();
					fileName = vDirectories.get(selectedRowIndex).getFileName();
					
					fileName = this.pHakgwa.initialize(fileName);
					this.pGangjwaSelection.initialize(fileName);
				}
				
			} else if (source.equals(this.pHakgwa.getSelectionModel())) {
				
				System.out.println("Hakgwa click");
				int selectedRowIndex = this.pHakgwa.getSelectedRow();
				if(selectedRowIndex >= 0) {
					Vector<VDirectory> vDirectories = pHakgwa.getDirectory();
					fileName = vDirectories.get(selectedRowIndex).getFileName();
	
					this.pGangjwaSelection.initialize(fileName);
				}
			}
		}
		
	}
	
	private class PDirectory extends JTable {
		private static final long serialVersionUID = 1L;

		private DefaultTableModel tableModel;
		
		Vector<String> header;
		private Vector<VDirectory> vDirectories;
		
		public PDirectory(String title, ListSelectionHandler listSelectionHandler) {
			// attributes
			this.getSelectionModel().addListSelectionListener(listSelectionHandler);
			
			// data model
			header = new Vector<String>();
			header.addElement(title);
			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);
		}

		public String initialize(String fileName) {
			return this.getData(fileName);			
		}

		public String getData(String fileName) {
			// table initialize
			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);
			
			CDirectory cDirectory = new CDirectory();
			vDirectories = cDirectory.getData(fileName);
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
		
		public Vector<VDirectory> getDirectory() {
			return this.vDirectories;
		}
	}
}


















