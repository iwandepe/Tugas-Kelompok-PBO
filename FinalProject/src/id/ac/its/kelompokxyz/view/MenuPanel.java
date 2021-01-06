package id.ac.its.kelompokxyz.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import id.ac.its.kelompokxyz.app.Commons;

public class MenuPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	JLabel hScore = new JLabel("BEST SCORE : 0");
	JLabel coin = new JLabel("Coins : 0");

	public MenuPanel(ViewButtonListener viewButtonListener) {
		setFocusable(true);
        requestFocusInWindow();
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(new Color(93, 100, 111));
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
		setFocusable(true);
		requestFocusInWindow();

        GridBagConstraints gbcTitle = new GridBagConstraints();
        gbcTitle.gridwidth = GridBagConstraints.REMAINDER;
        gbcTitle.anchor = GridBagConstraints.NORTH;
        
        ImageIcon imgTitle = new ImageIcon("src/resources/title.png");
        add(new JLabel(imgTitle),gbcTitle);
        repaint();

        hScore.setFont(new Font("Fixedsys Regular", 1, 15));
        add(hScore, gbcTitle);
//        updateScore();
        
        GridBagConstraints gbcBtn = new GridBagConstraints();
        gbcBtn.gridwidth = GridBagConstraints.REMAINDER;
        gbcBtn.anchor = GridBagConstraints.CENTER;
        gbcBtn.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttons = new JPanel(new GridBagLayout());

        buttons.add(viewButtonListener.getbPlay(), gbcBtn);
        buttons.add(viewButtonListener.getbDif(), gbcBtn);
        buttons.add(viewButtonListener.getbCredit(), gbcBtn);
        buttons.add(viewButtonListener.getbExit(), gbcBtn);

        gbcBtn.weighty = 1;
        add(buttons, gbcBtn);

        System.out.println("Here!");
	}
	
//	public void updateScore() {
////		new CreateIO(0, "plyr1");
//		ReadIO data = new ReadIO();
//		hScore.setText("BEST SCORE : "+ data.getScore());
//	}
	
}
