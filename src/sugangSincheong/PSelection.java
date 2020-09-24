package sugangSincheong;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PSelection extends JPanel {


	private static final long serialVersionUID = 1L;
	
	private PHakgwaSelection pHakgwaSelection;
	private PGangjwaSelection pGangjwaSelection;
	
	public PSelection() {
	
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.pHakgwaSelection = new PHakgwaSelection();
		this.add(this.pHakgwaSelection);
		
		JScrollPane scrollPane = new JScrollPane();
		this.pGangjwaSelection = new PGangjwaSelection();
		scrollPane.setViewportView(this.pGangjwaSelection);
		this.add(scrollPane);
		
	}
	
}
