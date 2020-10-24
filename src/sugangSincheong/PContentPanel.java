package sugangSincheong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import valueObject.VGangjwa;

public class PContentPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private PSelection pSelection;
	private PMove pMove1;
	private PResult pMiridamgi;
	private PMove pMove2;
	private PResult pSincheong;
	
	private ActionListener actionHandler;
	private ListSelectionListener listSelectionHandler;
	
	public PContentPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.actionHandler = new ActionHandler();
		this.listSelectionHandler = new ListSelectionHandler();
		
		this.pSelection = new PSelection(listSelectionHandler);
		this.add(this.pSelection);
		
		this.pMove1 = new PMove(this.actionHandler);
		this.add(this.pMove1);
		
		this.pMiridamgi = new PResult();
		JScrollPane scrollPane = new JScrollPane(this.pMiridamgi);
		this.add(scrollPane);
		
		this.pMove2 = new PMove(this.actionHandler);
		this.add(this.pMove2);
		
		this.pSincheong = new PResult();
		scrollPane = new JScrollPane(this.pSincheong);
		this.add(scrollPane);
	}

	public void initialize() {
		this.pSelection.initialize();
		this.pMove1.initialize();
		this.pMiridamgi.initialize();
		this.pMove2.initialize();
		this.pSincheong.initialize();
		
	}
	
	/////////////////////////////
	// table event handler
	/////////////////////////////
	
	private void updateGangjwas(Object source) {
				
		String fileName = this.pSelection.getHakgwaSelection().update(source);
		Vector<VGangjwa> vGangjwas = this.pSelection.getGangjwaSelection().getData(fileName);
		vGangjwas = this.pMiridamgi.removeDuplicated(vGangjwas);
		vGangjwas = this.pSincheong.removeDuplicated(vGangjwas);
		this.pSelection.getGangjwaSelection().updateTableContents(vGangjwas);
		
	}
	
	public class ListSelectionHandler implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent event) {
			updateGangjwas(event.getSource());			
		}
	}
	
	/////////////////////////////
	// button event handler
	/////////////////////////////
	private void moveGangjwas(Object source) {
		Vector<VGangjwa> vSelectedGangjwas;
		
		if(source.equals(this.pMove1.getMoveRightButton())) {
			System.out.println("move1right");
			
			vSelectedGangjwas = this.pSelection.getSelectedGangjwas();
			vSelectedGangjwas = this.pMiridamgi.removeDuplicated(vSelectedGangjwas);
			vSelectedGangjwas = this.pSincheong.removeDuplicated(vSelectedGangjwas);
//			vSelectedGangjwas = this.removeDuplicatedGangjwas(vSelectedGangjwas);
			
			this.pMiridamgi.addGangjwas(vSelectedGangjwas);
			
		} else if(source.equals(this.pMove1.getMoveLeftButton())) {
			
			vSelectedGangjwas = this.pMiridamgi.removeGangjwas();
			
		} else if(source.equals(this.pMove2.getMoveRightButton())) {
			
			vSelectedGangjwas = this.pMiridamgi.removeGangjwas();
			this.pSincheong.addGangjwas(vSelectedGangjwas);
			
		} else if(source.equals(this.pMove2.getMoveLeftButton())) {
			
			vSelectedGangjwas = this.pSincheong.removeGangjwas();
			this.pMiridamgi.addGangjwas(vSelectedGangjwas);			
			
		}
		
	}
	
	private Vector<VGangjwa> removeDuplicatedGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		
		Vector<VGangjwa> vSingCheongGangjwas = this.pSincheong.getGangjwas();
		
		for(int i = vSelectedGangjwas.size()-1; i>=0; i--) {
		
			for(VGangjwa vSincheongGangjwa : vSingCheongGangjwas) {
				if(vSelectedGangjwas.get(i).getNumber().equals(vSincheongGangjwa.getNumber())) {
					vSelectedGangjwas.remove(i);
				}
			}
			
		}
		return vSelectedGangjwas;
		
	}

	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			System.out.println("button click");
			moveGangjwas(event.getSource());
		}
		
	}
	
}
