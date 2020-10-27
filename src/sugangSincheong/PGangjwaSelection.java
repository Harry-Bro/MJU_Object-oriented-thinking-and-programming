package sugangSincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import control.CGangjwa;

import valueObject.VGangjwa;

public class PGangjwaSelection extends JTable {
	
	private static final long serialVersionUID = 1L;

	DefaultTableModel tableModel;
	 
	 Vector<String> header;	 
	 Vector<VGangjwa> vGangjwas;
	 ListSelectionListener listSelectionHandler;

	public PGangjwaSelection(ListSelectionListener ListSelectionHandler) {
		
		this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
	    header = new Vector<String>();
		header.addElement("강좌번호");
		header.addElement("강좌명");
		header.addElement("담당교수");
		header.addElement("학점");
		header.addElement("시간");
		
		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(this.tableModel);
		this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);		
		
	}
	
	public void initialize(String fileName) {
			this.update(fileName);
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
		updateTableContents(this.vGangjwas);
		
		return vSelectedGangjwas;
		
	}
	
	public Vector<VGangjwa> getData(String fileName) {
		
		CGangjwa cGangjwa = new CGangjwa();
		Vector<VGangjwa> newVGangjwa = cGangjwa.getData(fileName);
		return newVGangjwa;
		
	}
	
	public void updateTableContents(Vector<VGangjwa> newGangjwas) {

		this.getSelectionModel().removeListSelectionListener(this.listSelectionHandler);
	
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
		}
		
		this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
			
	}
	
	public void update(String fileName) {
		Vector<VGangjwa> newGangjwas = this.getData(fileName);

		this.updateTableContents(newGangjwas);
		
	}

	

	
	
}

