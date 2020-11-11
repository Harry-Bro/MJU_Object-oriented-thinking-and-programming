package sugangSincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EPGangjwaSelection;
import control.CGangjwa;

import valueObject.VGangjwa;

public class PGangjwaSelection extends JTable {
	
	private static final long serialVersionUID = 1L;

	private DefaultTableModel tableModel;
	 
	private Vector<String> header;	 
	private Vector<VGangjwa> vGangjwas;
	private ListSelectionListener listSelectionHandler;
	private CGangjwa cGangjwa;
	
	private PResult pMiridamgi;
	private PResult pSincheong;

	public PGangjwaSelection(ListSelectionListener ListSelectionHandler) {
		
//		this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
	    header = new Vector<String>();
	    
	    for(EPGangjwaSelection eGangjwaSelection: EPGangjwaSelection.values()) {
	    	header.addElement(eGangjwaSelection.getText());
	    }
		
		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(this.tableModel);
//		this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);		
		
	}
	
	public void initialize(String fileName, PResult pMiridamgi, PResult pSincheong) {
		this.pMiridamgi = pMiridamgi;
		this.pSincheong = pSincheong;
		this.update(fileName);
	}
	
	public Vector<VGangjwa> getData() {
		return this.vGangjwas;
	}
	
	public Vector<VGangjwa> getSelectedGangjwas() {
		Vector<VGangjwa> vSelectedGangjwas = new Vector<>();
		
		int[] indices = this.getSelectedRows();
		// 여기서 데이터 지우셈. 아래 for문은 거꾸로 돌리셈.
		for(int index: indices) {
			
			vSelectedGangjwas.add(this.vGangjwas.get(index));
		}
		
		for(int i = indices.length -1; i >= 0; i--) {
			this.vGangjwas.remove(i);
		}
		updateTableContents();
		
		return vSelectedGangjwas;
		
	}
	
	private void getData(String fileName) {
		
		cGangjwa = new CGangjwa();
		this.vGangjwas = cGangjwa.getData(fileName);
				
	}
	
	public void removeDuplicated(Vector<VGangjwa> vSelectedGangjwas) {
		
		
		for(int i = this.vGangjwas.size()-1; i>=0; i--) {			
			for(VGangjwa vGangjwa : vSelectedGangjwas) {
				if(this.vGangjwas.get(i).getNumber().equals(vGangjwa.getNumber())) {
					this.vGangjwas.remove(i);
					break;
				}
			}			
		}
		
//		return vSelectedGangjwas;
		
	}
	
	private void updateTableContents() {

		this.getSelectionModel().removeListSelectionListener(this.listSelectionHandler);
	
		this.tableModel.setRowCount(0);
		this.tableModel = new DefaultTableModel(header, 0);

		for(VGangjwa vGangjwa : this.vGangjwas) {
			Vector<String> row = new Vector<String>();
			row.add(vGangjwa.getNumber());
			row.add(vGangjwa.getName());
			row.add(vGangjwa.getProfessor());
			row.add(vGangjwa.getCredit());
			row.add(vGangjwa.getTime());
			this.tableModel.addRow(row);	
		}
		
		if(this.vGangjwas.size()>0) {
			this.setModel(this.tableModel);
			this.getSelectionModel().addSelectionInterval(0, 0);
		}
		
		this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
			
	}
	

	public void update(String fileName) {
		
		this.getData(fileName);
		this.removeDuplicated(this.pMiridamgi.getGangjwas());
		this.removeDuplicated(this.pSincheong.getGangjwas());
		this.updateTableContents();
		
	}
	
	public Vector<VGangjwa> removeSelectedGangjwas() {
		
		int[] indices = this.getSelectedRows();
		Vector<VGangjwa> vRemovedGangjwas = new Vector<VGangjwa>();
		
		for(int i = indices.length-1; i>= 0; i--) {
			
			VGangjwa vRemovedGangjwa = this.vGangjwas.remove(indices[i]);
			vRemovedGangjwas.add(vRemovedGangjwa);
			
		}
		this.updateTableContents();
		
		return vRemovedGangjwas;
		
	}
	
	public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		this.vGangjwas.addAll(vSelectedGangjwas);
		this.updateTableContents();
	}
	
	
}

