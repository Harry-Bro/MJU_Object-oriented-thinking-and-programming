package mainFrame;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import constants.Constants.EToolBar;

public class PToolBar extends JToolBar {
   private static final long serialVersionUID = 1L;
   
   public PToolBar() {
      for (EToolBar eTool: EToolBar.values()) {
         ImageIcon originIcon = new ImageIcon(eTool.getPath());  
         Image originImg = originIcon.getImage(); 
         Image changedImg= originImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH );
         ImageIcon Icon = new ImageIcon(changedImg);
         JButton button = new JButton(Icon);
          this.add(button);
   
      }
   }

   public void initialize() {
      
   }
}