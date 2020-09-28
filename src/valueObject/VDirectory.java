package valueObject;

public class VDirectory {
	// 초기 속성 
	private String name;
	private String fileName;
	// 속성 세팅 
	public VDirectory(String name, String fileName) {
		this.name = name;
		this.fileName = fileName;
	}
	// 값을 읽어올 수만 있음 
	public String getName() {
		return name;
	}
	public String getFileName() {
		return fileName;
	}

	
	
	
}
