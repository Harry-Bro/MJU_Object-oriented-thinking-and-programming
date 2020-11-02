package mainFrame;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants.ELoginDialog;
import control.CLogin;
import control.CUser;
import mainFrame.Main.ActionHandler;
import valueObject.VLogin;
import valueObject.VUser;

public class PLoginDialog extends JDialog {
	// attributes
	private static final long serialVersionUID = 1L;

	// components
	private JLabel userIdLabel;
	private JTextField UserIdTextField;
	private JLabel passwordLabel;
	private JTextField passwordTextField;
	private JButton okButton;
	private JButton cancelButton;
	
	private CLogin cLogin;
	private CUser cUser;
		
	public PLoginDialog(ActionHandler actionHandler) {
		// attributes
		this.setSize(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.setLayout(new FlowLayout());
		
		// components
		JPanel line1 = new JPanel();
			this.userIdLabel = new JLabel(ELoginDialog.nameLabel.getText());
			line1.add(this.userIdLabel);		
			this.UserIdTextField = new JTextField(ELoginDialog.sizeNameText.getInt());
			line1.add(this.UserIdTextField);
		this.add(line1);
		JPanel line2 = new JPanel();
			this.passwordLabel = new JLabel(ELoginDialog.passwordLabel.getText());
			line2.add(this.passwordLabel);		
			this.passwordTextField = new JTextField(ELoginDialog.sizePasswordText.getInt());
			line2.add(this.passwordTextField);
		this.add(line2);
		JPanel line3 = new JPanel();
			this.okButton = new JButton(ELoginDialog.okButtonLabel.getText());
			this.okButton.addActionListener(actionHandler);
			this.okButton.setActionCommand(this.okButton.getText());
			this.getRootPane().setDefaultButton(this.okButton);
			
			line3.add(this.okButton);		
			this.cancelButton = new JButton(ELoginDialog.cancelButtonLabel.getText());
			this.cancelButton.addActionListener(actionHandler);
			this.cancelButton.setActionCommand(this.cancelButton.getText());
			line3.add(this.cancelButton);
		this.add(line3);
		
		// control
		this.cLogin = new CLogin();
		this.cUser = new CUser();
	}
	
	public void initialize() {
	}	

	public VUser validateUser(String actionCommand) {
		VUser vUser = null;
		if (actionCommand.contentEquals(this.okButton.getText())) {
			VLogin vLogin = new VLogin(this.UserIdTextField.getText(), this.passwordTextField.getText());	

			boolean bLoginSuccess = cLogin.validate(vLogin);			
			if (bLoginSuccess) {
				
				vUser = cUser.getUser(vLogin.getUserId());			
				if (vUser == null) {
					// 시스템 에러 - 회원 정보가 존재 하지 않음
					JOptionPane.showConfirmDialog(this, ELoginDialog.noAccountInfo.getText());
				}
			} else {
				// 
				JOptionPane.showConfirmDialog(this, ELoginDialog.loginFailed.getText());
			}
		}
		return vUser;
	}

}
