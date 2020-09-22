package sugangSincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PSelection extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private PDirectory pCampus;
	private PDirectory pCollege;
	private PDirectory pHakgwa;
	private PDirectory pGangjwa;
	
	
	public PSelection() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane scrollpane;
		
		scrollpane = new JScrollPane();
		Vector<String> rowCampusData = new Vector<>();
		rowCampusData.addElement("인문 캠퍼스");
		rowCampusData.addElement("자연 캠퍼스");
		this.pCampus = new PDirectory("캠퍼스", rowCampusData);
		scrollpane.setViewportView(this.pCampus);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		Vector<String> rowCollegeData = new Vector<>();
		rowCollegeData.addElement("경영대학");
		rowCollegeData.addElement("인문대학");
		rowCollegeData.addElement("ICT대학");
		this.pCollege = new PDirectory("대학", rowCollegeData);
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		Vector<String> rowHakgwaData = new Vector<>();
		rowHakgwaData.addElement("경영학과");
		rowHakgwaData.addElement("경영정보학과");
		rowHakgwaData.addElement("행정학과");
		this.pHakgwa = new PDirectory("학과", rowHakgwaData);
		scrollpane.setViewportView(this.pHakgwa);
		this.add(scrollpane);
	}

}
