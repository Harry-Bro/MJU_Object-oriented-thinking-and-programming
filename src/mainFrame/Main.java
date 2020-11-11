package mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import valueObject.VUser;

public class Main {

	private PLoginDialog pLoginDialog;
	private PMainFrame pMainFrame;
	
	public Main() {
		ActionHandler actionHandler = new ActionHandler();
		this.pLoginDialog = new PLoginDialog(actionHandler);
		this.pLoginDialog.setVisible(true);	
	}
	
	private void initialize() {
		this.pLoginDialog.initialize();
	}
	
	private void validateUser(String actionCommand) {
		VUser vUser = pLoginDialog.validateUser(actionCommand);
		if (vUser != null) {			
			this.pMainFrame = new PMainFrame();
			this.pMainFrame.setVisible(true);
			this.pMainFrame.initialize(vUser);
			this.pLoginDialog.dispose();
		}
	}
	
	public class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			validateUser(event.getActionCommand());
		}		
	}
	
	public static void main(String[] args) {		
		Main main = new Main();
		main.initialize();		
	}
}
