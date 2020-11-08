package sugangSincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CResult;
import valueObject.VGangjwa;

public class PResult extends JTable {
	
	private static final long serialVersionUID = 1L;

	private DefaultTableModel tableModel;
	private Vector<VGangjwa> vGangjwas;
	
	public PResult() {
		Vector<String> header = new Vector<>();
		header.addElement("°­ÁÂ¹øÈ£");
		header.addElement("°­ÁÂ¸í");
		
		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(tableModel);
		
		this.vGangjwas = new Vector<>();
	}

	public void initialize(String fileName) {
		
		CResult cResult = new CResult();
		this.vGangjwas = cResult.get(fileName);
		this.updateTableData();
		
	}
	
	public void save(String fileName) {
		
		CResult cResult = new CResult();
		cResult.save(fileName, this.vGangjwas);
		
		
	}
	
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

	public Vector<VGangjwa> getGangjwas() {

		return this.vGangjwas;
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

	
	
	
}
