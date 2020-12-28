package id.ac.its.kelompokxyz;

import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import coba2.MyButton;

public class DifficultyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JPanel menuPanel = new JPanel();
	JFrame frame;
	
	JLabel hScore = new JLabel("Best Time : 0");
	JLabel coin = new JLabel("Coins : 0");
	
	MyButton bEasy = new MyButton("EASY"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			changePanel(frame, new Board(frame, 10));
		};
	};
	MyButton bMedium = new MyButton("MEDIUM"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			changePanel(frame, new Board(frame, 5));
		};
	};
	MyButton bHard = new MyButton("HARD"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			changePanel(frame, new Board(frame, 3));
		};
	};
	MyButton bBack = new MyButton("EXIT") {
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			System.exit(0);
		};
	};

	public DifficultyPanel(JFrame frame) {
		this.frame = frame;
		setFocusable(true);
        requestFocusInWindow();
        
		menuPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		menuPanel.setBackground(new java.awt.Color(93, 100, 111));
		menuPanel.setLayout(new GridBagLayout());
		menuPanel.setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
		menuPanel.setFocusable(true);
		menuPanel.requestFocusInWindow();
		
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        menuPanel.add(new JLabel("CHOOSE DIFFICULTY"), gbc);
        menuPanel.add(hScore, gbc);
        updateScore();
        menuPanel.add(coin, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttons = new JPanel(new GridBagLayout());
        
        buttons.add(bEasy, gbc);
        buttons.add(bMedium, gbc);
        buttons.add(bHard, gbc);
        buttons.add(bBack, gbc);

        gbc.weighty = 1;
        menuPanel.add(buttons, gbc);
        
        add(menuPanel);

	}
	
	public static void changePanel(JFrame frame, JPanel added) {
		frame.setContentPane(added);
		frame.invalidate();
		frame.validate();
		added.setFocusable(true);
		added.requestFocusInWindow();
	}
	
	public void updateScore() {
//		new CreateIO(0, "plyr1");
		ReadIO data = new ReadIO();
		hScore.setText("Best Time : "+ data.getScore());
	}

}
