package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MDirectory;
import valueObject.VDirectory;

public class CDirectory {

	public Vector<VDirectory> getData(String fileName) {
		
		DataAccessObject dao = new DataAccessObject(); // fileName�ְ� �� �޶��
		Vector<MDirectory> mDirectories = dao.getDirectories(fileName);
		
		Vector<VDirectory> vDirectories = new Vector<>(); // ���� ���� V�� �ٽ� ���� 
		
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
