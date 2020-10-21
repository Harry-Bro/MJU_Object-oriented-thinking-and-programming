package sugangSincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import control.CGangjwa;
import sugangSincheong.PSelection.ListSelectionHandler;
import valueObject.VGangjwa;

public class PGangjwaSelection extends JTable {
	
	private final long serialVersionUID = 1L;

	 DefaultTableModel tableModel;
	 
	 Vector<String> header;	 
	 Vector<VGangjwa> vGangjwas;

	public PGangjwaSelection(ListSelectionListener ListSelectionHandler) {
		
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
			this.update(fileName);
	}
	
	public Vector<VGangjwa> getSelectedGangjwas() {
		Vector<VGangjwa> vSelectedGangjwas = new Vector<>();
		
		int[] indices = this.getSelectedRows();
		// ���⼭ ������ �����. �Ʒ� for���� �Ųٷ� ������.
		for(int index: indices) {
			
			vSelectedGangjwas.add(this.vGangjwas.get(index));
		}
		
		return vSelectedGangjwas;
	}
	

	
	private void updateTableContents(Vector<VGangjwa> newGangjwas) {
		// TODO Auto-generated method stub
//		CGangjwa cGangjwa = new CGangjwa();
		this.vGangjwas= newGangjwas;
		this.tableModel.setRowCount(0);
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
	
	public void update(String fileName) {
		Vector<VGangjwa> newGangjwas = this.getData(fileName);

		this.updateTableContents(newGangjwas);
		
	}

	public Vector<VGangjwa> getData(String fileName) {
		
		Vector<VGangjwa>
		
	}

	
	
}

