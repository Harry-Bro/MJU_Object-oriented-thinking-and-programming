package constants;

public class Constants {
	
	public enum ELoginDialog {
		width("300"),
		height("200"),
		nameLabel("ID "),
		sizeNameText("10"),
		passwordLabel("PW "),
		sizePasswordText("10"),
		okButtonLabel("ok"),
		cancelButtonLabel("cancel");
		
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
		WIDTH(400),
		HEIGHT(600);
		
		private int size;
	
		EMainFrame(int size) {
			this.size = size;
		}
		public int getSize() {
			return this.size;
		}
	}
	
	public enum EMenuBar {
		FILE("FILE"),
		EDIT("EDIT");
		
		private String text;
		
		EMenuBar(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileMenu {
		NEW("NEW"),
		OPEN("OPEN"),
		SAVE("SAVE"),
		SAVEAS("SAVE-AS"),
		PRINT("PRINT"),
		EXIT("EXIT");
		
		private String text;
		
		EFileMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EEditMenu {
		COPY("COPY"),
		CUT("CUT"),
		PASTE("PASTE"),
		DELETE("DELETE");
		
		private String text;
		
		EEditMenu(String text) {
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
	
	
}
