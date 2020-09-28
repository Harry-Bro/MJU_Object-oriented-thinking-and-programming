package model;

import java.util.Scanner;

public class MDirectory {

	private Scanner scanner;
	private String id;
	private String name;
	private String fileName;
	
	public MDirectory(Scanner scanner) {
		this.scanner = scanner;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFileName() {
		return fileName;
	}
	
	public void read() {
		this.id = scanner.next();
		System.out.println("id: " + id);
		this.name = scanner.next();
		System.out.println(name);
		this.fileName = scanner.next();
		System.out.println(fileName);
	}
	
	
	
}
