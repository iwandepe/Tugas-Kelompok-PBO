package id.ac.its.kelompokxyz.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import id.ac.its.kelompokxyz.app.Commons;
import id.ac.its.kelompokxyz.app.CreateIO;
import id.ac.its.kelompokxyz.app.Credits;
import id.ac.its.kelompokxyz.app.DifficultyPanel;
import id.ac.its.kelompokxyz.app.MyButton;
import id.ac.its.kelompokxyz.app.ReadIO;

public class MenuPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	JPanel menuPanel = new JPanel();
	JFrame frame;
	
	JLabel hScore = new JLabel("BEST SCORE : 0");
	JLabel coin = new JLabel("Coins : 0");
	
	MyButton bPlay = new MyButton("PLAY"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			changePanel(frame, new DifficultyPanel(frame));
		};
	};
	MyButton bDif = new MyButton("RESET SCORE"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			// Function MAP / LEVEL
			new CreateIO().reset();
//			updateScore();
		};
	};
	MyButton bCredit = new MyButton("CREDITS"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			changePanel(frame, new Credits(frame));
		};
	};
	MyButton bExit = new MyButton("EXIT") {
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			System.exit(0);
		};
	};

	public MenuPanel(JFrame frame) {
		this.frame = frame;
		setFocusable(true);
        requestFocusInWindow();
        
		menuPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		menuPanel.setBackground(new java.awt.Color(93, 100, 111));
		menuPanel.setLayout(new GridBagLayout());
		menuPanel.setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
		menuPanel.setFocusable(true);
		menuPanel.requestFocusInWindow();

        GridBagConstraints gbcTitle = new GridBagConstraints();
        gbcTitle.gridwidth = GridBagConstraints.REMAINDER;
        gbcTitle.anchor = GridBagConstraints.NORTH;
        
        ImageIcon imgTitle = new ImageIcon("src/resources/title.png");
        menuPanel.add(new JLabel(imgTitle),gbcTitle);
        menuPanel.repaint();

        hScore.setFont(new java.awt.Font("Fixedsys Regular", 1, 15));
        menuPanel.add(hScore, gbcTitle);
//        updateScore();
        
        GridBagConstraints gbcBtn = new GridBagConstraints();
        gbcBtn.gridwidth = GridBagConstraints.REMAINDER;
        gbcBtn.anchor = GridBagConstraints.CENTER;
        gbcBtn.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttons = new JPanel(new GridBagLayout());

        buttons.add(bPlay, gbcBtn);
        buttons.add(bDif, gbcBtn);
        buttons.add(bCredit, gbcBtn);
        buttons.add(bExit, gbcBtn);

        gbcBtn.weighty = 1;
        menuPanel.add(buttons, gbcBtn);
        
        add(menuPanel);

	}
	
	public static void changePanel(JFrame frame, JPanel added) {
		frame.setContentPane(added);
		frame.invalidate();
		frame.validate();
		added.setFocusable(true);
		added.requestFocusInWindow();
	}
	
//	public void updateScore() {
////		new CreateIO(0, "plyr1");
//		ReadIO data = new ReadIO();
//		hScore.setText("BEST SCORE : "+ data.getScore());
//	}
	
}
