package sugangSincheong;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PContentPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private PSelection pSelection;
	private PMove pMove1;
	private PMiridamgi pMiridamgi;
	private PMove pMove2;
	private PResult pSincheong;

	public PContentPanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.pSelection = new PSelection();
		this.add(this.pSelection);
		
		this.pMove1 = new PMove();
		this.add(this.pSelection);
		
		this.pMiridamgi = new PMiridamgi();
		this.add(this.pMiridamgi);
		
		this.pMove2 = new PMove();
		this.add(this.pMove2);
		
		this.pSincheong = new PResult();
		this.add(this.pSincheong);
	}
}
