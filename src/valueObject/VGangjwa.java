package valueObject;

import java.util.Vector;

public class VGangjwa {
	private String number;
	private String name;
	private String professor;
	private String credit;
	private String time;
	
	public VGangjwa(String number, String name, 
			String professor, String credit, String time) {
		this.number = number;
		this.name = name;
		this.professor = professor;
		this.credit = credit;
		this.time = time;
		
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
}
