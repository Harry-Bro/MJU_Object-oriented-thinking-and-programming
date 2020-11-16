package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MDirectory;
import model.MModel;
import valueObject.VDirectory;

public class CDirectory {
	
	public CDirectory() {
		
	}
	
	public Vector<VDirectory> getData(String fileName)  {
		DataAccessObject dataAccessObject = new DataAccessObject();
		Vector<MModel> mModels = dataAccessObject.getModels(fileName, MDirectory.class);
		
		Vector<VDirectory> vDirectories = new Vector<>();
		for(MModel mModel : mModels) {
			MDirectory mMirectory = (MDirectory) mModel;
			VDirectory vDirectory = new VDirectory(
					mMirectory.getName(),
					mMirectory.getFileName()
			);
			
			vDirectories.add(vDirectory);
		}
		return vDirectories;
	}

}
