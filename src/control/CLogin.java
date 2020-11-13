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
				JOptionPane.showMessageDialog(null, "아이디가 있느나 비밀번호가 틀렸습니다.");
				// password mismatch
			}
		} else {
			JOptionPane.showMessageDialog(null, "회원 가입이 안되었거나 아이디를 잘 못 입력하셨습니다.");
			// no userId - 회원 가입 안됨 혹은 아이디 잘 못 입력
		}
		return bLoginSuccess;
	}
}
