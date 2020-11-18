package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VGangjwa;

public class DataAccessObject {
	
	public MModel getAModel(String fileName, Class<? extends MModel> clazz, String key) {
		MLogin mLogin = null;
		try {
			Scanner scanner = new Scanner(new File(fileName), "MS949");
			MModel mModel = clazz.getConstructor(Scanner.class).newInstance(scanner);
			
			while (scanner.hasNext()) {
				String mModelKey = mModel.read();
				if (mModelKey.contentEquals(key)) {
					scanner.close();
					return mModel;
				}
			}
			scanner.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public Vector<MModel> getModels(String fileName, Class<? extends MModel> clazz)  {
		Vector<MModel> mModels = new Vector<>();
		
		try {
			Scanner scanner = new Scanner(new File("lectureInfo/data/"+fileName), "MS949");
			while (scanner.hasNext()) {

				MModel mModel = clazz.getConstructor(Scanner.class).newInstance(scanner);
				mModel.read();
				mModels.add(mModel);
				
			}
			scanner.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mModels;
	}

	public void saveResults(String fileName, Vector<VGangjwa> vGangjwas) {
		File path = new File("lectureInfo/data" + fileName);
		try(BufferedWriter bufferWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "MS949"))) {
			for(VGangjwa vGangjwa : vGangjwas) {
				MGangjwa mGangjwa = new MGangjwa(bufferWriter, vGangjwa);
				mGangjwa.save();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


//	public MLogin getLogin(String userId) {
//		MLogin mLogin = null;
//		try {
//			Scanner scanner = new Scanner(new File("userInfo/userId"), "MS949");
//			mLogin = new MLogin(scanner, userId);
//			while (scanner.hasNext()) {
//				boolean found = mLogin.read();
//				if (found) {
//					scanner.close();
//					return mLogin;
//				}
//			}
//			scanner.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	public MUser getUser(String userId) {
//		MUser mUser = null;
//		try {
//			Scanner scanner = new Scanner(new File("userInfo/"+userId), "MS949");
//			mUser = new MUser(scanner, userId);
//			while (scanner.hasNext()) {
//				boolean found = mUser.read();
//				if (found) {
//					scanner.close();
//					return mUser;
//				}
//			}
//			scanner.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
//	public Vector<MGangjwa> getResults(String fileName) {
//		Vector<MGangjwa> mGangjwas = new Vector<MGangjwa>();
//		try {
//			Scanner scanner = new Scanner(new File("userInfo/"+fileName), "MS949");
//			while (scanner.hasNext()) {
//				MGangjwa mGangjwa = new MGangjwa(scanner);
//				mGangjwa.read();
//				mGangjwas.add(mGangjwa);
//			}
//			scanner.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		return mGangjwas;
//	}

	
}
