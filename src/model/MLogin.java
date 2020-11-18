package model;

import java.util.Scanner;

public class MLogin extends MModel {
	private Scanner scanner;
	
	private String userId;
	private String password;
	
	public MLogin(Scanner scanner) {
		this.scanner = scanner;
		
	}

	public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}

	public String read() {		

		this.userId = scanner.next();
		this.password = scanner.next();
		return this.userId;
	}
}
