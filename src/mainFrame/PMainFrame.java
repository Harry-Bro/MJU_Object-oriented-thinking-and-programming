package mainFrame;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import constants.Constants;
import sugangSincheong.PSugangSincheongPanel;
import valueObject.VUser;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private WindowListener windowListener;
	
	private PMenuBar pMenuBar;
	private PToolBar pToolBar;
	private PSugangSincheongPanel pMainPanel;
	
	// constructor
	public PMainFrame() {
		// set attributes
		this.setSize(
				Constants.EMainFrame.width.getInt(), 
				Constants.EMainFrame.height.getInt()
				);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		// ADD Window listener
		this.windowListener = new WindowHandler();
		this.addWindowListener(windowListener);
		
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
	
	private void save() {
		
		this.pMainPanel.save();
		
	}
	
	public class WindowHandler implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// 종료되는 중 
			
			save();
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// 완전히 종료된 후 불리는 
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// 윈도우 최소화 됐을 때 
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// 윈도우 최소화에서 다시 돌아올 
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// 창이 활성화 되어있을 때 
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// 윈도우 활성화 되어 있지 않을 때 
			
		}
		
	}
}
