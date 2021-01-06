package id.ac.its.kelompokxyz.app;

import java.awt.LayoutManager;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Credits extends JPanel {

	private static final long serialVersionUID = 1L;
	JFrame frame;
	public Credits(JFrame frame) {
		ImageIcon img = new ImageIcon("src/resources/credmin.png");
		JLabel lbl = new JLabel(img);
		MyButton menubtn = new MyButton("MAIN MENU"){
			private static final long serialVersionUID = 1L;
			@Override
			public void btnMouseClicked(MouseEvent evt) {
				MainPanel.changePanel(frame, new MainPanel(frame));
			};
		};
		lbl.setAlignmentX(CENTER_ALIGNMENT);
		setLayout((LayoutManager) new BoxLayout(this, BoxLayout.Y_AXIS));
		add(lbl);
		add(menubtn);
        
	}
}
