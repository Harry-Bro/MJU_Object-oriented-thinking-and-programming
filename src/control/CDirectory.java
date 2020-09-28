package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MDirectory;
import valueObject.VDirectory;

public class CDirectory {

	public Vector<VDirectory> getData(String fileName) {
		
		DataAccessObject dao = new DataAccessObject(); // fileName주고 모델 달라고
		Vector<MDirectory> mDirectories = dao.getDirectories(fileName);
		
		Vector<VDirectory> vDirectories = new Vector<>(); // 받은 모델을 V로 다시 넣음 
		
		for(MDirectory MDirectory:mDirectories) {
			VDirectory vDirectory = new VDirectory(
					MDirectory.getName(),
					MDirectory.getFileName()
			);
			
			vDirectories.add(vDirectory);
			
		}
		
		return vDirectories;
	}

	
	
}
