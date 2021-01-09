package id.ac.its.kelompokxyz.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import id.ac.its.kelompokxyz.util.Commons;

public class GameOverPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel hScore = new JLabel("Best Time : 0");
	JLabel label;
	
	public GameOverPanel(ViewListener viewListener, String msg, boolean isWin) {
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
        
        label = new JLabel(msg);
        label.setFont(new Font("Century Gothic", 1, 20));
        
        add(label, gbc);
        add(hScore, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttons = new JPanel(new GridBagLayout());
        
        if(isWin)
        	buttons.add(viewListener.getMenuOverwin(), gbc);
        else {
        	buttons.add(viewListener.getMenuOverlose(), gbc);
        	buttons.add(viewListener.getbExitbyOver(), gbc);
        }
        buttons.setBackground(new Color(93, 100, 111));
        gbc.weighty = 1;
        add(buttons, gbc);
	}
	
	public void updateScore(int score) {
		hScore.setText("BEST SCORE : " + score);
		System.out.println("updatescore : 0");
	}
}
