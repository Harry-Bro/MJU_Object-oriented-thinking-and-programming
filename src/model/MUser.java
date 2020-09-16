package model;

import java.util.Scanner;

public class MUser {
	
	private Scanner scanner;
	private String userId;
	private String name;
	private String number;
	private String major;
	
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
	public String getNumber() {
		return number;
	}
	public String getMajor() {
		return major;
	}

	public boolean read() {		
		String userId = scanner.next();
		this.name = scanner.next();
		this.number = scanner.next();
		this.major = scanner.next();
		
		if (this.userId.contentEquals(userId)) {
			return true;
		}
		return false;
	}
}
