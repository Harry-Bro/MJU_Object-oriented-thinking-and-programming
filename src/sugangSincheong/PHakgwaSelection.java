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
//	private PDirectory pGangjwa;
	
	private String fileName;
	
	
	public PHakgwaSelection(ListSelectionHandler listSelectionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.fileName = "root";
		
		JScrollPane scrollpane;
		
		scrollpane = new JScrollPane();
		this.pCampus = new PDirectory("캠퍼스", listSelectionHandler);
		scrollpane.setViewportView(this.pCampus);
		this.add(scrollpane);
		fileName = this.pCampus.getData(fileName);
		
		scrollpane = new JScrollPane();
		this.pCollege = new PDirectory("대학", listSelectionHandler);
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		fileName = this.pCollege.getData(fileName);
		
		scrollpane = new JScrollPane();
		this.pHakgwa = new PDirectory("학과", listSelectionHandler);
		scrollpane.setViewportView(this.pHakgwa);
		this.add(scrollpane);
		fileName = this.pHakgwa.getData(fileName);
	}
	

	public void update(Object source) {
		if(source.equals(this.pCampus)) {
			
		} else if(source.equals(this.pCollege)) {
			
		} else if(source.equals(this.pHakgwa)) {
			
		}
	}

	private class PDirectory extends JTable {
		private DefaultTableModel tableModel;
		
		public PDirectory(String title, ListSelectionHandler listSelectionHandler) {

			this.getSelectionModel().addListSelectionListener(listSelectionHandler);
			Vector<String> header = new Vector<String>();			
			
			header.addElement(title);
			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);
			
		}

		public String getData(String fileName) {
			
			CDirectory cDirectory = new CDirectory();
			Vector<VDirectory> vDirectories = cDirectory.getData(fileName);
			
			for(VDirectory vDirectory:vDirectories) {
				Vector<String> row = new Vector<>();
				System.out.println(vDirectory.getName());
				
				row.addElement(vDirectory.getName()); // 벡터에 담
				this.tableModel.addRow(row);
			}
			
			if(vDirectories.size() > 0) {
				this.getSelectionModel().addSelectionInterval(0, 0); // 0번째 로우를 선택함 
				return vDirectories.get(0).getFileName();
			}
			
			return null;
		}
	}

	
}
