package valueObject;

public class VDirectory {
	// �ʱ� �Ӽ� 
	private String name;
	private String fileName;
	// �Ӽ� ���� 
	public VDirectory(String name, String fileName) {
		this.name = name;
		this.fileName = fileName;
	}
	// ���� �о�� ���� ���� 
	public String getName() {
		return name;
	}
	public String getFileName() {
		return fileName;
	}

	
	
	
}
