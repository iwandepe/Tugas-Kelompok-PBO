package id.ac.its.kelompokxyz.view;

import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public CreditPanel(ViewListener viewListener) {
		ImageIcon img = new ImageIcon("src/resources/credmin.png");
		JLabel lbl = new JLabel(img);
		lbl.setAlignmentX(CENTER_ALIGNMENT);
		setLayout((LayoutManager) new BoxLayout(this, BoxLayout.Y_AXIS));
		add(lbl);
		add(viewListener.getMenubtn());
        
	}
}
