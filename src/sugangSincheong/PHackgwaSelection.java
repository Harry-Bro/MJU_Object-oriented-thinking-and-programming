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
import constants.Constants.EDirectory;
import control.CDirectory;
import model.MDirectory;
import valueObject.VDirectory;

public class PHackgwaSelection extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String fileName;
	
	public PDirectory pCampus;
	public PDirectory pCollege;
	public PDirectory pHackgwa;
	
	int hackgwaSelectedRow =-1;
	
	public PHackgwaSelection(ListSelectionListener listSelectionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JScrollPane scrollpane;
		scrollpane = new JScrollPane();
		this.pCampus = new PDirectory(EDirectory.campus.getText(), listSelectionHandler);
		scrollpane.setViewportView(this.pCampus);
		this.add(scrollpane);

		scrollpane = new JScrollPane();
		this.pCollege = new PDirectory(EDirectory.college.getText(), listSelectionHandler);
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pHackgwa = new PDirectory(EDirectory.hackgwa.getText(), listSelectionHandler);
		scrollpane.setViewportView(this.pHackgwa);
		this.add(scrollpane);
		
		
	}
	
	public void initialize() {
		
		this.fileName =EConfiguration.rootFileName.getText();
		fileName = this.pCampus.initialize(fileName);
		fileName = this.pCollege.initialize(fileName);
		fileName = this.pHackgwa.initialize(fileName);
	}
	
      public class PDirectory extends JTable{
    	  CDirectory cDirectory;
    	  
		private static final long serialVersionUID = 1L;
		private DefaultTableModel tableModel;
		public Vector<String> header;
		Vector<VDirectory> vDirectories;
		public ListSelectionListener listSelectionHandler;
		
		public PDirectory(String title, ListSelectionListener listSelectionHandler) {
			
			this.listSelectionHandler=listSelectionHandler;
			this.getSelectionModel().addListSelectionListener(listSelectionHandler);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
			String selectedFileName = this.vDirectories.get(selectedIndex).getFileName();
			return selectedFileName;
		}
		public String getData(String fileName) {
		   this.getSelectionModel().removeListSelectionListener(this.listSelectionHandler);
		   
			cDirectory = new CDirectory();
			vDirectories=null;
			this.tableModel.setRowCount(0); // √ ±‚»≠ 
			vDirectories = cDirectory.getData(fileName);
			for(VDirectory vDirectory : vDirectories) {
				Vector<String> row = new Vector<String>();
				row.add(vDirectory.getName());
				this.tableModel.addRow(row);	
			}
			String selectedFileName = null;
			if(vDirectories.size()>0) {
				this.setModel(this.tableModel);
				this.getSelectionModel().addSelectionInterval(0, 0);
				selectedFileName = vDirectories.get(0).getFileName();
			}
			
			this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
			return selectedFileName;
		}
		public Vector<String> getTitle(){
			return header;
		}
		public void setHeader(Vector<String> title){
			this.header = title;
		}
		
	 public Vector<VDirectory> getFileName(){
		 return vDirectories;
	 }
	 public void setInitialize() {
			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);
			
		}
	 
}

	public String update(Object source) {
		if(source.equals(pCampus.getSelectionModel())) {
			this.fileName = this.pCampus.getSelectedFileName();
			this.fileName = this.pCollege.getData(this.fileName);
			this.fileName = this.pHackgwa.getData(this.fileName);
		}
		else if(source.equals(pCollege.getSelectionModel())) {
			this.fileName = this.pCollege.getSelectedFileName();
			this.fileName = this.pHackgwa.getData(this.fileName);
		}
		else if(source.equals(pHackgwa.getSelectionModel())) {
			this.fileName = this.pHackgwa.getSelectedFileName();
		}
		
		return fileName;
		
		}

	public String getFileName() {
		return this.fileName;
	}
	
	public PDirectory getHackgwa() {
		return this.pHackgwa;
	}
		


}









