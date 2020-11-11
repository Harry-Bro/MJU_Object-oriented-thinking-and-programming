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
//		JScrollPane scrollPane = new JScrollPane(this.pMiridamgi);
//		this.add(scrollPane);
		this.add(pMiridamgi);
		this.pMove2 = new PMove(this.actionHandler);
		this.add(this.pMove2);
		
		this.pSincheong = new PResult();
//		scrollPane = new JScrollPane(this.pSincheong);
//		this.add(scrollPane);
		this.add(pSincheong);
	}

	public void initialize(VUser vUser) {
		this.vUser = vUser;
		
		this.pMove1.initialize();
		this.pMove2.initialize();
		
		this.pMiridamgi.initialize(vUser.getUserId() + EConfiguration.miridamgiFilePostfix.getText());
		this.pSincheong.initialize(vUser.getUserId() + EConfiguration.sincheongFilePostfix.getText());
		
		this.pSelection.initialize(this.pMiridamgi, this.pSincheong);
		
	}
	
	public void save() {
		this.pMiridamgi.save(vUser.getUserId() + EConfiguration.miridamgiFilePostfix.getText());
		this.pSincheong.save(vUser.getUserId() + EConfiguration.sincheongFilePostfix.getText());
		
	}
	
	/////////////////////////////
	// table event handler
	/////////////////////////////
	
	private void updateGangjwas(Object source) {
		
		this.pSelection.updateGangjwas(source);
		
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
	
	private void moveGangjwas(PGangjwaContainer source, PGangjwaContainer target) {
		Vector<VGangjwa> vSelectedGangjwas = source.removeSelectedGangjwas();
		target.addGangjwas(vSelectedGangjwas);
	}

	private void moveGangjwas(Object source) {
		
		
		if(source.equals(this.pMove1.getMoveRightButton())) {
			
			this.moveGangjwas(this.pSelection, this.pMiridamgi);
						
			
		} else if(source.equals(this.pMove1.getMoveLeftButton())) {
			this.moveGangjwas(this.pMiridamgi, this.pSelection);
			
		} else if(source.equals(this.pMove2.getMoveRightButton())) {
			this.moveGangjwas(this.pMiridamgi, this.pSincheong);
			

		} else if(source.equals(this.pMove2.getMoveLeftButton())) {
			this.moveGangjwas(this.pSincheong, this.pMiridamgi);
			
		}
		
	}

	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			
			moveGangjwas(event.getSource());
		}
		
	}

	
	
}
