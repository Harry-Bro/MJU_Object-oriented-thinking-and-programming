package sugangSincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import valueObject.VGangjwa;

public class PResult extends JTable {
	
	private static final long serialVersionUID = 1L;

	private DefaultTableModel tableModel;
	private Vector<VGangjwa> vGangjwas;
	
	public PResult() {
		Vector<String> header = new Vector<>();
		this.vGangjwas = new Vector<>();
		header.addElement("°­ÁÂ¹øÈ£");
		header.addElement("°­ÁÂ¸í");
	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	public Vector<VGangjwa> removeDuplicated(Vector<VGangjwa> vSelectedGangjwas) {
		
		
		for(int i = vSelectedGangjwas.size()-1; i>=0; i--) {
			
			for(VGangjwa vGangjwa : this.vGangjwas) {
				if(vSelectedGangjwas.get(i).getNumber().equals(vGangjwa.getNumber())) {
					vSelectedGangjwas.remove(i);
					break;
				}
			}
			
		}
		return vSelectedGangjwas;
		
	}

	public Vector<VGangjwa> removeGangjwas() {
		int[] indices = this.getSelectedRows();
		Vector<VGangjwa> vRemovedGangjwas = new Vector<>();
		
		for(int i=indices.length-1; i>= 0; i--) {
			VGangjwa vRemovedGangjwa = this.vGangjwas.remove(indices[i]);
			vRemovedGangjwas.add(vRemovedGangjwa);
		}
		
		this.updateTableData();
		return vRemovedGangjwas;
	}
	
//	private void moveSelectedGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
//		for(VGangjwa vSelectedGangjwa : vSelectedGangjwas) {
//			
//			boolean found = false;
//			for(VGangjwa vGangjwa : this.vGangjwas) {
//				if(vSelectedGangjwa.getNumber().equals(vGangjwa.getNumber())) {
//					found = true;
//					break;
//				}
//			}
//			if(!found) {
//				this.vGangjwas.add(vSelectedGangjwa);
//			}
//			
//		}
//	}
	
	private void updateTableData() {
		this.tableModel.setRowCount(0);
		
		for(VGangjwa vGangjwa : this.vGangjwas) {
			Vector<String> row = new Vector<>();
			
			row.add(vGangjwa.getNumber());
			row.add(vGangjwa.getName());
			this.tableModel.addRow(row);
			
		}
		
		if(this.vGangjwas.size() > 0) {
			this.getSelectionModel().addSelectionInterval(0, 0);
		}
	}

	public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		
//		this.moveSelectedGangjwas(vSelectedGangjwas);
		this.vGangjwas.addAll(vSelectedGangjwas);
		this.updateTableData();		
		
	}

	public Vector<VGangjwa> getGangjwas() {
		// TODO Auto-generated method stub
		return this.vGangjwas;
	}

	
	
	
}
