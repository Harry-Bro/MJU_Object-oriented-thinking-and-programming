package mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

	public static void main(String[] args) {
		//test2
		ActionHandler actionHandler = new ActionHandler();
	
		
		PLoginDialog pLoginDialog = new PLoginDialog(actionHandler);
		pLoginDialog.setVisible(true);
		
		// memory allocation
		// invoke constructor
//		PMainFrame pMainFrame = new PMainFrame();
//		pMainFrame.setVisible(true);
	}
	
	
	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals(okButton.getText())) {
				validateUser();
			}	
		}		
	}
	
}

