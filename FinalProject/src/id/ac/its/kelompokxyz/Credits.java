package id.ac.its.kelompokxyz;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Credits extends JPanel {

	private static final long serialVersionUID = 1L;
	JLabel gameTitle = new JLabel("<html><h1>BRICK BREAKER</h1></html>");
	JLabel desc = new JLabel("<html><p>This is simple game by zeetCode <br>that modified with mainMenu GUI <br> and some new fiture that make this game <br>incredible</p></html>");
	JLabel dev = new JLabel("<html>Mohammad Faderik I H<br>Iwan Dwi Prakoso<br>Dias Tri Kurniasari</html>");
	JFrame frame;
	public Credits(JFrame frame) {
		this.frame = frame;
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        
        add(gameTitle, CENTER_ALIGNMENT);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        add(desc, CENTER_ALIGNMENT);
        add(dev, gbc);
        
	}
}
