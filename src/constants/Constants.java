package constants;

public class Constants {
	
	

	public enum EConfiguration {
		
		miridamgiFilePostfix("M"),
		sincheongFilePostfix("S"),
		rootFileName("root");
		
		private String text;
		private EConfiguration(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
		
	}
	
	public enum ELoginDialog {
		width("300"),
		height("200"),
		nameLabel(" 아이디   "),
		sizeNameText("10"),
		passwordLabel("비밀번호"),
		sizePasswordText("10"),
		okButtonLabel("ok"),
		cancelButtonLabel("cancel"),
		
		noAccountInfo("회원 정보가 존재하지 않음."),
		loginFailed("아이디나 비밀번호가 다릅니다.");
		
		private String text;
		private ELoginDialog(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}

	
	public enum EMainFrame {
		
		width("1000"),
		height("600");
		
		private String text;
	
		private EMainFrame(String text) {
			this.text = text;
		}
		
		public String getText() {
			return this.text;
		}
		
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EMenuBar {
		FILE("파일"),
		EDIT("편집");
		
		private String text;
		
		EMenuBar(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EToolBar{
		
		BASKET("BASKET", "data/BASKET.png"),
		ENROLLMENT("actionHandler", "data/ENROLLMENT.png"),
		PERSONAL("PERSONAL", "data/PERSONAL.png"),
		GRADE("GRADE", "data/GRADE.png");
		
		
		private String text;
		private String path;

		EToolBar(String text, String path){
			this.text = text;
			this.path=path;
		}

		public String getText() {
			return this.text;
		}
		
		public String getPath() {
			return this.path;
		}

	}
	
	public enum EFileMenu {
		NEW("생성"),
		OPEN("열기"),
		SAVE("저장"),
		SAVEAS("다른이름으로"),
		PRINT("프린트"),
		EXIT("종료");
		
		private String text;
		
		EFileMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EEditMenu {
		COPY("복사"),
		CUT("자르기"),
		PASTE("붙여넣기"),
		DELETE("삭제");
		
		private String text;
		
		EEditMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EDirecory {
		
		campus("캠퍼"),
		college("대학"),
		hakgwa("학과");
		
		private String text;
		private EDirecory(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
		
	}
	
	public enum EPGangjwaSelection {
		
		gangjwaNo("강좌번호"),
		gangjwaName("강좌이름"),
		damdangGyosu("담당"),
		hakjeom("학점"),
		time("시간");
		
		private String text;
		private EPGangjwaSelection(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPResult {
		
		gangjwaNo("강좌번호"),
		gangjwaName("강좌이름");
		
		private String text;
		private EPResult(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
}
