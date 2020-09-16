package sugangSincheong;
import javax.swing.JLabel;
import javax.swing.JPanel;

import valueObject.VUser;

public class PHeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private VUser vUser;
	public static JLabel welcomeLabel;
	
	public PHeaderPanel(VUser vUser) {
		this.vUser = vUser;
		this.welcomeLabel = new JLabel("�� �ȳ��ϼ���.");
		welcomeLabel.setText(vUser.getMajor()+" "+vUser.getNumber()+" " +vUser.getName()+"�� �ȳ��ϼ���.");
		this.add(this.welcomeLabel);
		
	}

}
