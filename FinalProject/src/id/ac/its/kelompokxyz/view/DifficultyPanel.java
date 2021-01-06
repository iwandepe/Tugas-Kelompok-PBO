package id.ac.its.kelompokxyz.view;

import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import id.ac.its.kelompokxyz.app.Board;
import id.ac.its.kelompokxyz.app.MyButton;
import id.ac.its.kelompokxyz.app.ReadIO;
import id.ac.its.kelompokxyz.util.*;
import id.ac.its.kelompokxyz.model.*;

public class DifficultyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JPanel menuPanel = new JPanel();
	JFrame frame;
	
	JLabel hScore = new JLabel("Best Time : 0");
//	JLabel coin = new JLabel("Coins : 0");

	public DifficultyPanel(JFrame frame, ViewButtonListener viewButtonListener) {
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
//        updateScore();

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttons = new JPanel(new GridBagLayout());
        
        buttons.add(viewButtonListener.getbEasy(), gbc);
        buttons.add(viewButtonListener.getbMedium(), gbc);
        buttons.add(viewButtonListener.getbHard(), gbc);
        buttons.add(viewButtonListener.getbBack(), gbc);

        gbc.weighty = 1;
        menuPanel.add(buttons, gbc);
        
        add(menuPanel);

	}
	
//	public void updateScore() {
////		new CreateIO(0, "plyr1");
//		ReadIO data = new ReadIO();
//		hScore.setText("Best Time : "+ data.getScore());
//	}

}
