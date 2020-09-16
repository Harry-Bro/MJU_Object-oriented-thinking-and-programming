package control;

import model.DataAccessObject;
import model.MLogin;
import model.MUser;
import valueObject.VUser;

public class CUser {

	public VUser getUser(String userId) {
		
		VUser vUser = new VUser();
		DataAccessObject dataAccessObject = new DataAccessObject();
		MUser mUser = dataAccessObject.getUser(userId);
		
		vUser.setUserId(mUser.getUserId());
		vUser.setName(mUser.getName());
		vUser.setNumber(mUser.getNumber());
		vUser.setMajor(mUser.getMajor());
		
		return vUser;
	}

}
