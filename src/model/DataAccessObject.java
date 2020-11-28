package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Vector;

public class DataAccessObject {
	
	public MModel getAModel(String fileName, Class<? extends MModel> clazz, String key) {
		MLogin mLogin = null;
		try {
			Scanner scanner = new Scanner(new File(fileName), "MS949");
			MModel mModel = clazz.getConstructor().newInstance();
			
			while (scanner.hasNext()) {
				String mModelKey = mModel.read(scanner);
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

				MModel mModel = clazz.getConstructor().newInstance();
				mModel.read(scanner);
				mModels.add(mModel);
				
			}
			scanner.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mModels;
	}

	public void save(String fileName, Vector<MModel> mModels) {
		File path = new File("lectureInfo/data" + fileName);
		try(BufferedWriter bufferWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "MS949"))) {
			for(MModel mModel : mModels) {
				mModel.save(bufferWriter);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
}
