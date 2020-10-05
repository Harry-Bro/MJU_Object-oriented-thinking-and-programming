package mainFrame;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import constants.Constants;
import sugangSincheong.PSugangSincheongPanel;
import valueObject.VUser;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private PMenuBar pMenuBar;
	private PToolBar pToolBar;
	private PSugangSincheongPanel pMainPanel;
	
	// constructor
	public PMainFrame() {
		// set attributes
		this.setSize(
				Constants.EMainFrame.WIDTH.getSize(), 
				Constants.EMainFrame.HEIGHT.getSize()
				);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		// create and register components
		this.pMenuBar = new PMenuBar();
		this.setJMenuBar(this.pMenuBar);		
		
		this.pToolBar = new PToolBar();
		this.add(this.pToolBar, BorderLayout.NORTH);
		
		this.pMainPanel = new PSugangSincheongPanel();
		this.add(this.pMainPanel, BorderLayout.CENTER);	
	}
	
	public void initialize(VUser vUser) {
		this.pMenuBar.initialize();
		this.pToolBar.initialize();
		this.pMainPanel.initialize(vUser);		
	}
}
