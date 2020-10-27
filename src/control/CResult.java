package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MGangjwa;
import valueObject.VGangjwa;

public class CResult {

	public CResult() {
		
	}
	
	public void save(String fileName, Vector<VGangjwa> vGangjwas) {
		
		DataAccessObject dao = new DataAccessObject();
		dao.saveResult(fileName, vGangjwas);
		
	}

	public Vector<VGangjwa> get(String fileName) {
		// TODO Auto-generated method stub
		
		DataAccessObject dao = new DataAccessObject();
		Vector<MGangjwa> mGangjwas = dao.getResult(fileName);
		
		Vector<VGangjwa> vGangjwas = new Vector<>();
		
		for(MGangjwa mGangjwa : mGangjwas) {
			VGangjwa vGangjwa = new VGangjwa(mGangjwa.getNumber(), mGangjwa.getName(), 
					mGangjwa.getProfessor(), mGangjwa.getCredit(), mGangjwa.getTime());
			
			vGangjwas.add(vGangjwa);
		}
		
		return vGangjwas;
	}

	
	
}
