package id.ac.its.kelompokxyz.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import id.ac.its.kelompokxyz.util.*;

public class DifficultyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JLabel hScore = new JLabel("Best Score : 0");

	public DifficultyPanel(ViewListener viewListener) {
		setFocusable(true);
        requestFocusInWindow();
        
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(new Color(93, 100, 111));
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
		setFocusable(true);
		requestFocusInWindow();
		
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        add(new JLabel("CHOOSE DIFFICULTY"), gbc);
        add(hScore, gbc);
//        updateScore();

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttons = new JPanel(new GridBagLayout());
        
        buttons.add(viewListener.getbEasy(), gbc);
        buttons.add(viewListener.getbMedium(), gbc);
        buttons.add(viewListener.getbHard(), gbc);
        buttons.add(viewListener.getbBack(), gbc);

        gbc.weighty = 1;
        add(buttons, gbc);

	}
	
	public void updateScore(int score) {
		hScore.setText("BEST SCORE : " + score);
		System.out.println("updatescore : 0");
	}

}
