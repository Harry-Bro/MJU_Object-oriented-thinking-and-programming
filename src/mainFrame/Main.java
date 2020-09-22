package mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import valueObject.VUser;

public class Main {
	
	private PLoginDialog pLoginDialog;
	
	private void run() {
		ActionHandler actionHandler = new ActionHandler();
		this.pLoginDialog = new PLoginDialog(actionHandler);
		this.pLoginDialog.setVisible(true);
		
	}
	
	private void validateUser(String actionCommand) {
		VUser vUser = pLoginDialog.validateUser(actionCommand);
		if (vUser != null) {
			PMainFrame pMainFrame = new PMainFrame(vUser);
			pMainFrame.setVisible(true);
		}
		this.pLoginDialog.dispose();
	}
	
	public class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			validateUser(event.getActionCommand());
		}
	}
	
	public static void main(String[] args) {

		
		Main main = new Main();
		main.run();
		
	}
	

}

