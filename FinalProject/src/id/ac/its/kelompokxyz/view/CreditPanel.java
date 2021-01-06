package id.ac.its.kelompokxyz.view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CreditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public CreditPanel(ViewButtonListener viewButtonListener) {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		ImageIcon img = new ImageIcon("src/resources/credmin.png");
		JLabel lbl = new JLabel(img);
		lbl.setAlignmentX(CENTER_ALIGNMENT);
		setLayout((LayoutManager) new BoxLayout(this, BoxLayout.Y_AXIS));
		add(lbl);
		add(viewButtonListener.getMenubtn());
        
	}
}
