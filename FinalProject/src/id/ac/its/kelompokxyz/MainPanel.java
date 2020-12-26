package id.ac.its.kelompokxyz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	JPanel menuPanel = new JPanel();
	
	JLabel hScore = new JLabel("High Score : 0");
	JLabel coin = new JLabel("Coins : 0");
	JButton bPlay = new JButton("PLAY");
	JButton bDif = new JButton("DIFICULTY");
	JButton bMap = new JButton("MAP");
	JButton bExit = new JButton("EXIT");
	 
	public MainPanel() {
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
        bPlay.addActionListener(e -> {
    		switchPanel(menuPanel, new Board());

		});
        bDif.addActionListener(e -> {
        	// TEST SAVING DATA
    		new CreateIO(21,"member");
    		ReadIO r = new ReadIO();
    		
    		System.out.println(r.getName());
    		System.out.println(r.getScore());
    		

		});
        bMap.addActionListener(e -> {
    		

		});
        bExit.addActionListener(e -> {
    		System.exit(0);

		});
        
        buttons.add(bPlay, gbc);
        buttons.add(bDif, gbc);
        buttons.add(bMap, gbc);
        buttons.add(bExit, gbc);

        gbc.weighty = 1;
        menuPanel.add(buttons, gbc);
        
        add(menuPanel);

	}
	
    public void switchPanel(JPanel removed, JPanel added) {
    	remove(removed);
		revalidate();
		repaint();
		add(added);
		added.setFocusable(true);
		added.requestFocusInWindow();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
