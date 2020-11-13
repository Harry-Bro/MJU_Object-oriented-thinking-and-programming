package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

import valueObject.VGangjwa;

public class MGangjwa {
	private Scanner scanner;
	
	private BufferedWriter bufferWriter;
	
	private String id;
	private String name;
	private String lecturer;
	private String credit;
	private String time;
	
		
	public MGangjwa(Scanner scanner) {
		this.scanner = scanner;
	}

	public MGangjwa(BufferedWriter bufferWriter, VGangjwa vGangjwa) {
		// TODO Auto-generated constructor stub
		//
		
		this.bufferWriter = bufferWriter;
		this.id = vGangjwa.getId();
		this.name = vGangjwa.getName();
		this.lecturer = vGangjwa.getLecturer();
		this.credit = vGangjwa.getCredit();
		this.time = vGangjwa.getTime();
				
	}

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLecturer() {
		return lecturer;
	}
	public String getCredit() {
		return credit;
	}
	public String getTime() {
		return time;
	}

	public void read() {	
		
		this.id = scanner.next();
		this.name = scanner.next();
		this.lecturer = scanner.next();
		this.credit = scanner.next();
		this.time = scanner.next();
	}

	public void save() {

		try {
			
			this.bufferWriter.write(this.id + " ");
			this.bufferWriter.write(this.name + " ");
			this.bufferWriter.write(this.lecturer + " ");
			this.bufferWriter.write(this.credit + " ");
			this.bufferWriter.write(this.time + "\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}