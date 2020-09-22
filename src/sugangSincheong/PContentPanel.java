package sugangSincheong;
import java.awt.CardLayout;

import javax.swing.JPanel;

public class PContentPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private PSelection pSelection;
	private PMove pMove1;
	private PMiridamgi pMiridamgi;
	private PMove pMove2;
	private PResult pResult;

	public PContentPanel() {
		
		this.setLayout(new CardLayout());
		
		this.pSelection = new PSelection();
		this.add(this.pSelection);
		
		this.pMove1 = new PMove();
		this.add(this.pSelection);
		
		this.pMiridamgi = new PMiridamgi();
		this.add(this.pMiridamgi);
		
		this.pMove2 = new PMove();
		this.add(this.pMove2);
		
		this.pResult = new PResult();
		this.add(this.pResult);
	}
}
