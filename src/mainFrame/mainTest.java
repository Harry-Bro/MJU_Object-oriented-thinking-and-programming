package mainFrame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class mainTest {

	public static void main(String[] args) throws IOException {
	
		File dir = new File("lectureInfo");
		File files[] = dir.listFiles();
		
//		files[0].getName()

		for (int i = 0; i < files.length; i++) {
		    System.out.println("file: " + files[i].getName());
		    String path = files[i].getPath();
		    System.out.println(path);
		    
		    // read
		    FileReader fr = new FileReader(path);
		    BufferedReader br = new BufferedReader(fr);
		    String str = "";
		    String addStr = "";
		    while((addStr = br.readLine()) != null) {
		    	str += addStr;
		    }
		    System.out.println(str);
		    
		    
//		    try {
//				File fr = new File(path);
//				FileWriter fw = new FileWriter(file)
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		}
		
		
		
	}
	
	
	
}
