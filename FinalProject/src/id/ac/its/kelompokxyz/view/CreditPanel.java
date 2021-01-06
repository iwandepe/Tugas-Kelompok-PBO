package id.ac.its.kelompokxyz.view;

import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	JFrame frame;
	
	public CreditPanel(JFrame frame, ViewButtonListener viewButtonListener) {
		ImageIcon img = new ImageIcon("src/resources/credmin.png");
		JLabel lbl = new JLabel(img);
		lbl.setAlignmentX(CENTER_ALIGNMENT);
		setLayout((LayoutManager) new BoxLayout(this, BoxLayout.Y_AXIS));
		add(lbl);
		add(viewButtonListener.getMenubtn());
        
	}
}
