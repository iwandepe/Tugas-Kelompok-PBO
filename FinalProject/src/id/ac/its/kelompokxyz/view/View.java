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
    private final ViewListener viewListener = new ViewListener();

	public View(List<Ball> balls, List<Brick> bricks, Paddle paddle) {
		menuPanel = new MenuPanel(viewListener);
		creditPanel = new CreditPanel(viewListener);
		difficultyPanel = new DifficultyPanel(viewListener);
		gamePanel = new GamePanel(balls, bricks, paddle);
		gameOverPanel = new GameOverPanel(viewListener);
		initUI();
	}
	
	private void initUI() {
		frame = new JFrame("JaBrick Java Game");
		frame.addKeyListener(viewListener);
		frame.setFocusable(true);
		
		content = new JPanel();
    	frame.setLayout(new BorderLayout(10,10));
    	frame.setLocation(10,10);
    	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    	frame.setResizable(false);
    	frame.pack();
    	showGameMenu();
    	frame.setVisible(true);
    }

	public void updateView(List<Ball> balls, List<Brick> bricks, Paddle paddle) {
		gamePanel.updateGame(balls, bricks, paddle);
		gamePanel.repaint();
	}
	
	public void continueGame() {

		System.out.println("Continue game");
		viewListener.setPlaying();
		content.removeAll();
		content.add(gamePanel);
		gamePanel.setFocusable(true);
		content.validate();
		content.repaint();
		
		frame.setContentPane(content);
		frame.invalidate();
		frame.validate();
		frame.pack();
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
	
	public void showGameOver() {
		frame.setContentPane(gameOverPanel);
		frame.invalidate();
		frame.validate();
		frame.pack();
	}
}