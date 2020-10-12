package sugangSincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import valueObject.VGangjwa;

public class PSelection extends JPanel {
	private static final long serialVersionUID = 1L;

	private PHakgwaSelection pHakgwaSelection;
	private PGangjwaSelection pGangjwaSelection;
	
	public PSelection() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		ListSelectionHandler listSelectionHandler = new ListSelectionHandler();
		
		this.pHakgwaSelection = new PHakgwaSelection(listSelectionHandler);
		this.add(this.pHakgwaSelection);
		
		JScrollPane scrollPane = new JScrollPane();
		this.pGangjwaSelection = new PGangjwaSelection(listSelectionHandler);
		scrollPane.setViewportView(this.pGangjwaSelection);
		this.add(scrollPane);
	}
	
	public void initialize() {
		this.pHakgwaSelection.initialize(pGangjwaSelection);
		String fileName = this.pHakgwaSelection.getFileName();
		this.pGangjwaSelection.initialize(fileName);
	}
	
	private void update(Object source) {
		this.pHakgwaSelection.update(source);
		String fileName = this.pHakgwaSelection.getFileName();
		this.pGangjwaSelection.update(fileName);
	}
	
	public class ListSelectionHandler implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent event) {
			update(event.getSource());			
		}
	}

	public Vector<VGangjwa> getSelectedGangjwas() {
		
		
		return this.pGangjwaSelection.getSelectedGangjwas();
	}

	public Vector<VGangjwa> removeGangjwas() {
		
		
		return null;
	}

	
}
