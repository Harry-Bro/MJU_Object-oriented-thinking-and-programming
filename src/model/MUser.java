package model;

import java.util.Scanner;

public class MUser extends MModel{
	private Scanner scanner;
	
	private String userId;
	private String name;
	private String address;
	
	public MUser(Scanner scanner) {
		this.scanner = scanner;		
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

	public String read() {		
		this.userId = scanner.next();
		this.name = scanner.next();
		this.address = scanner.next();
		
		return this.userId;

	}
}
