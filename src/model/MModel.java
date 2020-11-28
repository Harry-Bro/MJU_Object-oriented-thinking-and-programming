package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;

public abstract class MModel {

	public MModel() {
		
	}

	public String read(Scanner scanner) {
		String key = null;
		try {
			Field[] fields = this.getClass().getDeclaredFields();
			for(Field field : fields) {
				String fieldValue = scanner.next();
				// field가 private인데 접근할 수 있도록 바꾸겠다 : setAccessible(true);
				field.setAccessible(true);
				field.set(this, fieldValue);
			}
			key = (String) fields[0].get(this);
		} catch (IllegalArgumentException | IllegalAccessException e) { 
				e.printStackTrace();
		}

		return key;
	}
	
	public void save(BufferedWriter bufferWriter) {
		try {
			Field[] fields = this.getClass().getDeclaredFields();
			
			for(Field field : fields) {								
				field.setAccessible(true);				
				bufferWriter.write(field.get(this) + " ");
			}
			bufferWriter.write("\n");
		} catch (IllegalArgumentException | IllegalAccessException | IOException e) { 
				e.printStackTrace();
		}
	}
	
}
