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
		rowCampusData.addElement("�ι� ķ�۽�");
		rowCampusData.addElement("�ڿ� ķ�۽�");
		this.pCampus = new PDirectory("ķ�۽�", rowCampusData);
		scrollpane.setViewportView(this.pCampus);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		Vector<String> rowCollegeData = new Vector<>();
		rowCollegeData.addElement("�濵����");
		rowCollegeData.addElement("�ι�����");
		rowCollegeData.addElement("ICT����");
		this.pCollege = new PDirectory("����", rowCollegeData);
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		Vector<String> rowHakgwaData = new Vector<>();
		rowHakgwaData.addElement("�濵�а�");
		rowHakgwaData.addElement("�濵�����а�");
		rowHakgwaData.addElement("�����а�");
		this.pHakgwa = new PDirectory("�а�", rowHakgwaData);
		scrollpane.setViewportView(this.pHakgwa);
		this.add(scrollpane);
	}

}
