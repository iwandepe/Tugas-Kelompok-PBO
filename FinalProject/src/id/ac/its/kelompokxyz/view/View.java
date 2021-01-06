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

	private final MenuPanel menuPanel;
	private final DifficultyPanel difficultyPanel;
	private final GamePanel gamePanel;
	private final GameOverPanel gameOverPanel;
    private JPanel content;
    private final ViewListener viewListener = new ViewListener();

	public View(List<Ball> balls, List<Brick> bricks, Paddle paddle) {
		menuPanel = new MenuPanel((JFrame)this);
		gamePanel = new GamePanel(balls, bricks, paddle);
		difficultyPanel = new DifficultyPanel((JFrame)this);
		gameOverPanel = new GameOverPanel();
		initUI(menuPanel);
	}
	
	private void initUI(MenuPanel menuPanel) {
    	setLayout(new BorderLayout(10,10));
    	setLocation(10,10);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setTitle("JaBrick Java Game");
    	setResizable(false);
    	setContentPane(menuPanel);
    	pack();
    	setVisible(true);
    }
	
	public void updateView() {
		
		gamePanel.repaint();
	}
}