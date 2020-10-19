package sugangSincheong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import valueObject.VGangjwa;

public class PContentPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private PSelection pSelection;
	private PMove pMove1;
	private PResult pMiridamgi;
	private PMove pMove2;
	private PResult pSincheong;
	
	private ActionListener actionHandler;
	
	public PContentPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.pSelection = new PSelection();
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
	

	
	private void update(Object source) {
		Vector<VGangjwa> vSelectedGangjwas;
		
		if(source.equals(this.pMove1.getMoveRightButton())) {
			
			vSelectedGangjwas = this.pSelection.getSelectedGangjwas();
			vSelectedGangjwas = this.removeDuplicatedGangjwas(vSelectedGangjwas);		
			
			this.pMiridamgi.addGangjwas(vSelectedGangjwas);
			
		} else if(source.equals(this.pMove1.getMoveLeftButton())) {
			
			vSelectedGangjwas = this.pMiridamgi.removeGangjwas();
			
		} else if(source.equals(this.pMove2.getMoveRightButton())) {
			
			vSelectedGangjwas = this.pMiridamgi.removeGangjwas();
			this.pMiridamgi.addGangjwas(vSelectedGangjwas);
			
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
			update(event.getSource());
		}
		
	}
	
}
