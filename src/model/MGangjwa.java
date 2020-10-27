package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import valueObject.VGangjwa;

public class MGangjwa {
	private Scanner scanner;
	
	private BufferedWriter bufferWriter;
	
	private String number;
	private String name;
	private String professor;
	private String credit;
	private String time;
	
		
	public MGangjwa(Scanner scanner) {
		this.scanner = scanner;
	}

	public MGangjwa(BufferedWriter bufferWriter, VGangjwa vGangjwa) {
		// TODO Auto-generated constructor stub
		//
		
		this.bufferWriter = bufferWriter;
		this.number = vGangjwa.getNumber();
		this.name = vGangjwa.getName();
		this.professor = vGangjwa.getProfessor();
		this.credit = vGangjwa.getCredit();
		this.time = vGangjwa.getTime();
				
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

	public void save() {
		// TODO Auto-generated method stub

		try {
			
			this.bufferWriter.write(this.number + " ");
			this.bufferWriter.write(this.name + " ");
			this.bufferWriter.write(this.professor + " ");
			this.bufferWriter.write(this.credit + " ");
			this.bufferWriter.write(this.time + "\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}