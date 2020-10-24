package sugangSincheong;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PMove extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton moveRight;
	private JButton moveLeft;
	
	public PMove(ActionListener actionHandler) {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.moveRight = new JButton(">>");
		this.moveLeft = new JButton("<<");
		
		this.moveRight.addActionListener(actionHandler);
		this.moveLeft.addActionListener(actionHandler);
		
		this.add(moveRight);
		this.add(moveLeft);
	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	public Object getMoveRightButton() {
		// TODO Auto-generated method stub
		return this.moveRight;
	}

	public Object getMoveLeftButton() {
		// TODO Auto-generated method stub
		return this.moveLeft;
	}
}
