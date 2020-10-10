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
	
	public void initialize(String fileName) {
		
	}
	
	public Vector<VGangjwa> getSelectedGangjwas() {
		
		return null;
	}
	
	public void update(String fileName) {
		
	}
	
	public String getData(String fileName) {
		
		CGangjwa cGangjwa = new CGangjwa();
		this.vGangjwas= cGangjwa.getData(fileName);
		this.tableModel = new DefaultTableModel(header, 0);

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
		
			
		return null;
	}

	
	
}

