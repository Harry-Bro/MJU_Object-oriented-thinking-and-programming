package sugangSincheong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import constants.Constants.EConfiguration;
import valueObject.VGangjwa;
import valueObject.VUser;

public class PContentPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private ListSelectionListener listSelectionHandler;
	private PSelection pSelection;
	
	private PResult pMiridamgi;
	private PResult pSincheong;
	private VUser vUser;
	
	private ActionListener actionHandler;
	private PMove pMove1;
	private PMove pMove2;

	
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

	public void initialize(VUser vUser) {
		this.vUser = vUser;
		
		this.pMove1.initialize();
		this.pMove2.initialize();
		
		this.pMiridamgi.initialize(vUser.getUserId() + EConfiguration.miridamgiFilePostfix.getText());
		this.pSincheong.initialize(vUser.getUserId() + EConfiguration.sincheongFilePostfix.getText());
		
		this.pSelection.initialize(this.pMiridamgi.getGangjwas(), this.pSincheong.getGangjwas());
//		this.pSelection.getHakgwaSelection().getHakgwa().listClick();
		
	}
	
	public void save() {
		this.pMiridamgi.save(vUser.getUserId() + EConfiguration.miridamgiFilePostfix.getText());
		this.pSincheong.save(vUser.getUserId() + EConfiguration.sincheongFilePostfix.getText());
		
	}
	
	/////////////////////////////
	// table event handler
	/////////////////////////////
	
	private void updateGangjwas(Object source) {
		
		this.pSelection.updateGangjwas(source, this.pMiridamgi.getGangjwas(), this.pSincheong.getGangjwas());
		
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
			
			vSelectedGangjwas = this.pSelection.getSelectedGangjwas();
			vSelectedGangjwas = this.pMiridamgi.removeDuplicated(vSelectedGangjwas);
			vSelectedGangjwas = this.pSincheong.removeDuplicated(vSelectedGangjwas);
			
			this.pMiridamgi.addGangjwas(vSelectedGangjwas);
//			this.pSelection.getHakgwaSelection().getHakgwa().listClick();
			
		} else if(source.equals(this.pMove1.getMoveLeftButton())) {
			
			vSelectedGangjwas = this.pMiridamgi.removeGangjwas();
//			this.pSelection.getHakgwaSelection().getHakgwa().listClick();
			
		} else if(source.equals(this.pMove2.getMoveRightButton())) {
			
			vSelectedGangjwas = this.pMiridamgi.removeGangjwas();
			this.pSincheong.addGangjwas(vSelectedGangjwas);
			
		} else if(source.equals(this.pMove2.getMoveLeftButton())) {
			
			vSelectedGangjwas = this.pSincheong.removeGangjwas();
			this.pMiridamgi.addGangjwas(vSelectedGangjwas);			
			
		}
		
	}

	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			
			moveGangjwas(event.getSource());
		}
		
	}

	
	
}
