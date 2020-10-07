package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MGangjwa;
import valueObject.VGangjwa;

public class CGangjwa {
	 
     public CGangjwa() {
 		
 	}
 	
 	public Vector<VGangjwa> getData(String fileName){
 		DataAccessObject dataAccessObject = new DataAccessObject();
 		Vector<MGangjwa> mGangjwas = dataAccessObject.getGangjwa(fileName);
 		
 		Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
 		for(MGangjwa mGangjwa : mGangjwas) {
 			VGangjwa vGangjwa = new VGangjwa(
 					mGangjwa.getNumber(),mGangjwa.getName(),mGangjwa.getProfessor(),
 					mGangjwa.getCredit(), mGangjwa.getTime()
 					);
 			vGangjwas.add(vGangjwa);
 		}
 		return vGangjwas;
 	}


}
