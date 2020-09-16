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
				bLoginSuccess = false; // password mismatch
			}
		} else {
			bLoginSuccess = false; // no userId
		}
		return bLoginSuccess;
	}
}
