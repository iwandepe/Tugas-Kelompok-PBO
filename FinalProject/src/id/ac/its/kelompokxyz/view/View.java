package id.ac.its.kelompokxyz.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.net.URL;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import id.ac.its.kelompokxyz.app.MainPanel;
import id.ac.its.kelompokxyz.controller.*;
import id.ac.its.kelompokxyz.model.*;
import id.ac.its.kelompokxyz.util.*;

public class View{

	private final MenuPanel menuPanel;
	private final DifficultyPanel difficultyPanel;
	private final GamePanel gamePanel;
	private final GameOverPanel gameOverPanel;
	private final CreditPanel creditPanel;
	private JFrame frame;
    private JPanel content;
    private final ViewKeyListener viewKeyListener = new ViewKeyListener();
    private final ViewButtonListener viewButtonListener = new ViewButtonListener();

	public View(List<Ball> balls, List<Brick> bricks, Paddle paddle) {
		menuPanel = new MenuPanel(viewButtonListener);
		creditPanel = new CreditPanel(viewButtonListener);
		difficultyPanel = new DifficultyPanel(viewButtonListener);
		gamePanel = new GamePanel(balls, bricks, paddle);
		gameOverPanel = new GameOverPanel();
		initUI();
	}
	
	private void initUI() {
		frame = new JFrame("JaBrick Java Game");
		frame.addKeyListener(viewKeyListener);
		
		content = new JPanel();
//		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
//        content.setBackground(Color.black);
//		frame.add(content);
    	frame.setLayout(new BorderLayout(10,10));
    	frame.setLocation(10,10);
    	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    	frame.setResizable(false);
    	frame.pack();
    	showGameMenu();
    	frame.setVisible(true);
    }
    
//    public void showMenu() {
//        System.out.println("MAIN MENU");
//        content.removeAll();
//        content.validate();
//        content.repaint();
//    }
	

	public void updateView(List<Ball> balls, List<Brick> bricks, Paddle paddle) {
		gamePanel.updateGame(balls, bricks, paddle);
		gamePanel.repaint();
		System.out.println("Repaint");
	}
	
	public void continueGame() {
		System.out.println("Continue game");
		viewKeyListener.setPlaying();
		content = (JPanel) frame.getContentPane();
		content.removeAll();
		content.add(gamePanel);
		content.setFocusable(true);
		content.validate();
		content.repaint();
	}
	
	public void showDifficulty() {
		frame.setContentPane(difficultyPanel);
		frame.invalidate();
		frame.validate();
		frame.pack();
	}
	
	public void showGameMenu() {
		frame.setContentPane(menuPanel);
		frame.invalidate();
		frame.validate();
		frame.pack();
	}
	
	public void showCredit() {
		frame.setContentPane(creditPanel);
		frame.invalidate();
		frame.validate();
		frame.pack();
	}
}