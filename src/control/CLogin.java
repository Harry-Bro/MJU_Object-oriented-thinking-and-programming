package control;

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
				// password mismatch
			}
		} else {
			// no userId - 회원 가입 안됨 혹은 아이디 잘 못 입력
		}
		return bLoginSuccess;
	}
}
