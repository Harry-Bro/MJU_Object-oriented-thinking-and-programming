package control;

import javax.swing.JOptionPane;

import model.DataAccessObject;
import model.MLogin;
import valueObject.VLogin;

public class CLogin {

	public boolean validate(VLogin vLogin) {
		boolean bLoginSuccess = false;
		
		DataAccessObject dataAccessObject = new DataAccessObject();
		MLogin mLogin = dataAccessObject.getLogin(vLogin.getUserId());
		
		if (mLogin != null) {
			if (vLogin.getPassword().contentEquals(mLogin.getPassword())) {
				bLoginSuccess = true;
			} else {
				JOptionPane.showMessageDialog(null, "���̵� �ִ��� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				// password mismatch
			}
		} else {
			JOptionPane.showMessageDialog(null, "ȸ�� ������ �ȵǾ��ų� ���̵� �� �� �Է��ϼ̽��ϴ�.");
			// no userId - ȸ�� ���� �ȵ� Ȥ�� ���̵� �� �� �Է�
		}
		return bLoginSuccess;
	}
}
