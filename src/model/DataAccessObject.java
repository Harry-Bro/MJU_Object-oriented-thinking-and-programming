package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class DataAccessObject {

	public MLogin getLogin(String userId) {
		MLogin mLogin = null;
		try {
			Scanner scanner = new Scanner(new File("userInfo/userId"));
			mLogin = new MLogin(scanner, userId);
			while (scanner.hasNext()) {
				boolean found = mLogin.read();
				if (found) {
					scanner.close();
					return mLogin;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public MUser getUser(String userId) {
		MUser mUser = null;
		try {
			Scanner scanner = new Scanner(new File("userInfo/"+userId));
			mUser = new MUser(scanner, userId);
			while (scanner.hasNext()) {
				boolean found = mUser.read();
				if (found) {
					scanner.close();
					return mUser;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Vector<MDirectory> getDirectories(String fileName) {
		Vector<MDirectory> mDirectories = new Vector<MDirectory>();
		try {
			Scanner scanner = new Scanner(new File("lectureInfo/"+ fileName));
			while (scanner.hasNext()) {
				MDirectory mDirectory = new MDirectory(scanner);
				mDirectory.read();
				mDirectories.add(mDirectory);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mDirectories;
	}

}
