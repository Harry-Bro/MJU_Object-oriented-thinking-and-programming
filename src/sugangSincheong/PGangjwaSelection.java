package sugangSincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CGangjwa;
import sugangSincheong.PSelection.ListSelectionHandler;
import valueObject.VGangjwa;

public class PGangjwaSelection extends JTable {
private final long serialVersionUID = 1L;

	 DefaultTableModel tableModel;
	 Vector<String> header;
	 
	 Vector<VGangjwa> vGangjwas;

	public PGangjwaSelection(ListSelectionHandler ListSelectionHandler) {
		
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	    header = new Vector<String>();
		header.addElement("강좌번호");
		header.addElement("강좌명");
		header.addElement("담당교수");
		header.addElement("학점");
		header.addElement("시간");
		
		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(this.tableModel);
		this.getSelectionModel().addListSelectionListener(ListSelectionHandler);
		
		
	}
	
	public String initialize(String fileName) {
		// Table initialize
		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(tableModel);
		
		fileName = getData(fileName);
		return fileName;
	}
	
	public String getData(String fileName) {
		if(fileName!=null) {
		CGangjwa cGangjwa = new CGangjwa();
		vGangjwas=null;
		this.tableModel = new DefaultTableModel(header, 0);
		vGangjwas = cGangjwa.getData(fileName);
		for(VGangjwa vGangjwa : vGangjwas) {
			Vector<String> row = new Vector<String>();
			row.add(vGangjwa.getNumber());
			row.add(vGangjwa.getName());
			row.add(vGangjwa.getProfessor());
			row.add(vGangjwa.getCredit());
			row.add(vGangjwa.getTime());
			this.tableModel.addRow(row);	
		}
			if(vGangjwas.size()>0) {
				this.setModel(this.tableModel);
				this.getSelectionModel().addSelectionInterval(0, 0);
				return vGangjwas.get(0).getNumber();
			}
		}
			
		return null;
	}

	public void update(String fileName) {
		
	}
	
}

