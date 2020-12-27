package id.ac.its.kelompokxyz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import coba2.MyButton;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JPanel menuPanel = new JPanel();
	JFrame frame;
	
	JLabel hScore = new JLabel("High Score : 0");
	JLabel coin = new JLabel("Coins : 0");
	
	MyButton bPlay = new MyButton("PLAY"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			changePanel(frame, new Board(frame));
		};
	};
	MyButton bDif = new MyButton("DIFICULTY"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			// Function MAP / LEVEL
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

	public MainPanel(JFrame frame) {
		this.frame = frame;
		setFocusable(true);
        requestFocusInWindow();
        
		menuPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		menuPanel.setLayout(new GridBagLayout());
		menuPanel.setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
		menuPanel.setFocusable(true);
		menuPanel.requestFocusInWindow();
		
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        menuPanel.add(new JLabel("BRICK BREAKER"), gbc);
        menuPanel.add(hScore, gbc);
        menuPanel.add(coin, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttons = new JPanel(new GridBagLayout());
        
        buttons.add(bPlay, gbc);
        buttons.add(bDif, gbc);
        buttons.add(bCredit, gbc);
        buttons.add(bExit, gbc);

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
	
    public void switchPanel(JPanel removed, JPanel added) {
    	remove(removed);
		revalidate();
		repaint();
		add(added);
		added.setFocusable(true);
		added.requestFocusInWindow();
    }

}
