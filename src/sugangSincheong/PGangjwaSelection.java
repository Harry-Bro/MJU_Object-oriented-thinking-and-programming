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
		header.addElement("���¹�ȣ");
		header.addElement("���¸�");
		header.addElement("��米��");
		header.addElement("����");
		header.addElement("�ð�");
		
		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(this.tableModel);
		this.getSelectionModel().addListSelectionListener(ListSelectionHandler);
		
		
	}
	
	public void initialize(String fileName) {
			this.getData(fileName);
	}
	
	public Vector<VGangjwa> getSelectedGangjwas() {
		Vector<VGangjwa> vSelectedGangjwas = new Vector<>();
		
		int[] indices = this.getSelectedRows();
		for(int index: indices) {
			vSelectedGangjwas.add(this.vGangjwas.get(index));
		}
		
		return vSelectedGangjwas;
	}
	
	public void update(String fileName) {
		this.getData(fileName);
		
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

