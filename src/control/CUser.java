package control;

import model.DataAccessObject;
import model.MModel;
import model.MUser;
import valueObject.VUser;

public class CUser {

	public VUser getUser(String userId) {
		VUser vUser = null;
		
		DataAccessObject dataAccessObject = new DataAccessObject();
		MModel mModel = dataAccessObject.getAModel("userInfo/"+userId, MUser.class, userId);
		
		if (mModel != null) {
			MUser mUser = (MUser) mModel;
			vUser = new VUser(mUser.getUserId(), mUser.getName(), mUser.getAddress());
		}
		return vUser;
	}

}
