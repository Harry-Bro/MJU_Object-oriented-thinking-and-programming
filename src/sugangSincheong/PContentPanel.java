package sugangSincheong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

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
		this.add(this.pMiridamgi);
		
		this.pMove2 = new PMove(this.actionHandler);
		this.add(this.pMove2);
		
		this.pSincheong = new PResult();
		this.add(this.pSincheong);
	}

	public void initialize() {
		this.pSelection.initialize();
		this.pMove1.initialize();
		this.pMiridamgi.initialize();
		this.pMove2.initialize();
		this.pSincheong.initialize();
		
	}
	
	private void update(Object source) {
		Vector<VGangjwa> vGangjwas;		
		
		if(source.equals(this.pMove1.getMoveRightButton())) {
			
			vGangjwas = this.pSelection.getSelectedGangjwas();
			this.pMiridamgi.addGangjwas(vGangjwas);
			
		} else if(source.equals(this.pMove1.getMoveLeftButton())) {
			
			vGangjwas = this.pMiridamgi.removeGangjwas();
			
		} else if(source.equals(this.pMove2.getMoveRightButton())) {
			
			vGangjwas = this.pMiridamgi.removeGangjwas();
			this.pMiridamgi.addGangjwas(vGangjwas);
			
		} else if(source.equals(this.pMove2.getMoveLeftButton())) {
			
			vGangjwas = this.pSincheong.removeGangjwas();
			this.pMiridamgi.addGangjwas(vGangjwas);			
			
		}
		
	}
	
	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			update(event.getSource());
		}
		
	}
	
}
