package model;

import java.util.Scanner;

public class MGangjwa {
	private Scanner scanner;
	
	private String number;
	private String name;
	private String professor;
	private String credit;
	private String time;
	
		
	public MGangjwa(Scanner scanner) {
		this.scanner = scanner;
	}

	public String getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public String getProfessor() {
		return professor;
	}
	public String getCredit() {
		return credit;
	}
	public String getTime() {
		return time;
	}

	public void read() {	
		
		this.number = scanner.next();
		this.name = scanner.next();
		this.professor = scanner.next();
		this.credit = scanner.next();
		this.time = scanner.next();
	}

}