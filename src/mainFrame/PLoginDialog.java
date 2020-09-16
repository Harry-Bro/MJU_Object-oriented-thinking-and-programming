package mainFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants.ELoginDialog;
import control.CLogin;
import control.CUser;
import sugangSincheong.PHeaderPanel;
import valueObject.VLogin;
import valueObject.VUser;

public class PLoginDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JLabel userIdLabel;
	private JTextField userIdtextField;
	private JLabel passwordLabel;
	private JTextField passwordTextField;
	private JButton okButton;
	private JButton cancelButton;
	
	
	public PLoginDialog() {
		this.setLocationRelativeTo(null);
		this.setSize(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());
		this.setResizable(false);

		this.setLayout(new FlowLayout());
		
		JPanel line1 = new JPanel();
			this.userIdLabel = new JLabel(ELoginDialog.nameLabel.getText());
			line1.add(this.userIdLabel);		
			this.userIdtextField = new JTextField(ELoginDialog.sizeNameText.getInt());
			line1.add(this.userIdtextField);
		this.add(line1);
		
		JPanel line2 = new JPanel();
			this.passwordLabel = new JLabel(ELoginDialog.passwordLabel.getText());
			line2.add(this.passwordLabel);		
			this.passwordTextField = new JTextField(ELoginDialog.sizePasswordText.getInt());
			line2.add(this.passwordTextField);
		this.add(line2);
		
		JPanel line3 = new JPanel();
			this.okButton = new JButton(ELoginDialog.okButtonLabel.getText());
			line3.add(this.okButton);	
			this.cancelButton = new JButton(ELoginDialog.cancelButtonLabel.getText());
			line3.add(this.cancelButton);
			this.add(line3);
			
//			this.okButton.addActionListener(actionHandler);
			this.okButton.setActionCommand(this.okButton.getText());
//			this.cancelButton.addActionListener(actionHandler);
			this.cancelButton.setActionCommand(this.cancelButton.getText());
			
	
	}
	
	private void validateUser() {
		CLogin cLogin = new CLogin();
		VLogin vLogin = new VLogin(this.userIdtextField.getText(), this.passwordTextField.getText());		
		boolean bLoginSuccess = cLogin.validate(vLogin);
		if (bLoginSuccess) {
			CUser cUser = new CUser();
			VUser vUser = cUser.getUser(vLogin.getUserId());
			PMainFrame pMainFrame = new PMainFrame(vUser);
			pMainFrame.setVisible(true);
			dispose();				
		}
	}
	

}
