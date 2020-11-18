package control;

import javax.swing.JOptionPane;

import model.DataAccessObject;
import model.MLogin;
import model.MModel;
import valueObject.VLogin;

public class CLogin {

	public boolean validate(VLogin vLogin) {
		boolean bLoginSuccess = false;
		
		DataAccessObject dataAccessObject = new DataAccessObject();
		MModel mModel = dataAccessObject.getAModel("userInfo/userId", MLogin.class, vLogin.getUserId());
		
		if (mModel != null) {
			MLogin mLogin = (MLogin) mModel;
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
