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

public class View extends JFrame{

	private static final long serialVersionUID = 1L;
	private final MenuPanel menuPanel;
	private final DifficultyPanel difficultyPanel;
	private final GamePanel gamePanel;
	private final GameOverPanel gameOverPanel;
	private final CreditPanel creditPanel;
    private JPanel content;
    private final ViewKeyListener viewKeyListener = new ViewKeyListener();
    private final ViewButtonListener viewButtonListener = new ViewButtonListener();

	public View(List<Ball> balls, List<Brick> bricks, Paddle paddle) {
		menuPanel = new MenuPanel((JFrame)this, viewButtonListener);
		creditPanel = new CreditPanel((JFrame)this, viewButtonListener);
		difficultyPanel = new DifficultyPanel((JFrame)this, viewButtonListener);
		gamePanel = new GamePanel(balls, bricks, paddle);
		gameOverPanel = new GameOverPanel();
		showGameMenu();
	}
	
	private void initUI() {
    	setLayout(new BorderLayout(10,10));
    	setLocation(10,10);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setTitle("JaBrick Java Game");
    	setResizable(false);
    	setContentPane(menuPanel);
    	pack();
    	setVisible(true);

    }
    
    public void showMenu() {
        System.out.println("MAIN MENU");
        viewListener.setGameMenu();
        content.removeAll();
        content.validate();
        content.repaint();

    }
	
	public void updateView() {
		gamePanel.repaint();
	}
	
	public void showDifficulty() {
    	initUI();
		setContentPane(difficultyPanel);
		pack();
		setVisible(true);
	}
	
	public void showGameMenu() {
		initUI();
		setContentPane(menuPanel);
		pack();
		setVisible(true);
	}
	
	public void showCredit() {
		initUI();
		setContentPane(creditPanel);
		pack();
		setVisible(true);
	}
}