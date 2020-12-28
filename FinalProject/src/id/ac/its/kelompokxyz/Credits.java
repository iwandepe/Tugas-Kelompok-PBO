package id.ac.its.kelompokxyz;

import java.awt.LayoutManager;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import coba2.MyButton;

public class Credits extends JPanel {

	private static final long serialVersionUID = 1L;
	JLabel gameTitle = new JLabel("<html><h1>BRICK BREAKER</h1></html>");
	JLabel desc = new JLabel("<html><p>This is simple game by zeetCode <br>that modified with mainMenu GUI <br> and some new fiture that make this game <br>incredible</p></html>");
	JLabel dev = new JLabel("<html>Mohammad Faderik I H<br>Iwan Dwi Prakoso<br>Dias Tri Kurniasari</html>");
	JFrame frame;
	public Credits(JFrame frame) {
//		ImageIcon img = new ImageIcon("src/resources/cred.jpeg");
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
