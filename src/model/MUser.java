package model;

import java.io.BufferedReader;
import java.util.Scanner;

public class MUser {
	private Scanner scanner;
	
	private String userId;
	private String name;
	private String address;
	
	public MUser(Scanner scanner, String userId) {
		this.scanner = scanner;
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}

	public boolean read() {		
//		String str[];
//		try {
//			str = scanner.readLine().split(" ");
//			String userId = str[0];
//			this.name = str[1];
//			this.address = str[2];
//			System.out.println(userId);
//			if (this.userId.contentEquals(userId)) {
////				System.out.println("same");
//				return true;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

		String userId = scanner.next();
		this.name = scanner.next();
		this.address = scanner.next();
		
		if (this.userId.contentEquals(userId)) {
			return true;
		}
		
		return false;
	}
}
