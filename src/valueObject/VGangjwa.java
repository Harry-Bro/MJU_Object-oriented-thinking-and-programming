package valueObject;

import java.util.Vector;

public class VGangjwa {
	private String id;
	private String name;
	private String lecturer;
	private String credit;
	private String time;
	
//	 생성자로 값을 초기화 시켜줌

	public VGangjwa(String number, String name, 
			String professor, String credit, String time) {
		this.id = number;
		this.name = name;
		this.lecturer = professor;
		this.credit = credit;
		this.time = time;
		
	}

	public String getNumber() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getProfessor() {
		return lecturer;
	}
	public String getCredit() {
		return credit;
	}
	public String getTime() {
		return time;
	}
}
