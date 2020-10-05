package control;

import model.DataAccessObject;
import model.MUser;
import valueObject.VUser;

public class CUser {

	public VUser getUser(String userId) {
		VUser vUser = null;
		
		DataAccessObject dataAccessObject = new DataAccessObject();
		MUser mUser = dataAccessObject.getUser(userId);
		if (mUser != null) {
			vUser = new VUser(mUser.getUserId(), mUser.getName(), mUser.getAddress());
		}
		return vUser;
	}

}
