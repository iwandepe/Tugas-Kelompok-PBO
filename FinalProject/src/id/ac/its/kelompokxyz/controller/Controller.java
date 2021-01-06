package id.ac.its.kelompokxyz.controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.Timer;
import id.ac.its.kelompokxyz.view.View;
import id.ac.its.kelompokxyz.util.Commons;
import id.ac.its.kelompokxyz.util.GameState;
import id.ac.its.kelompokxyz.controller.*;
import id.ac.its.kelompokxyz.model.Paddle;
import id.ac.its.kelompokxyz.model.Ball;
import id.ac.its.kelompokxyz.model.Brick;
import id.ac.its.kelompokxyz.model.Model;

public class Controller{
	private static final long serialVersionUID = 1L;
	private static int TICKS_PER_SECOND;
    private static Timer timer;
    private static Model model = new Model();
	private GameState gameState;
	int keyCode;
    
    public static void main(String[] args) {
    	timer = new Timer(TICKS_PER_SECOND, new GameCycle());
        timer.start();
    }
    
    public void respondToInput() {

        if (gameState == GameState.GAME_MENU) {
        	model.showGameMenu();
            return;
        }
        
        if (gameState == GameState.DIFFICULTY) {
        	model.showDifficulty();
        	return;
        }
        
        if (gameState == GameState.TO_GAME) {
        	model.continueGame();
        	timer.start();
        	return;
        }
        
        if (gameState == GameState.CREDIT) {
        	model.showCredit();
        	return;
        }
        
        if (gameState == GameState.PLAYING) {
            switch (this.keyCode) {
                case KeyEvent.VK_LEFT:
                    model.setMovePaddle(-1);
                    break;
                case KeyEvent.VK_RIGHT:
                    model.setMovePaddle(1);
                    break;
                default:
                    break;
            }
        }
    }
    
    public void setKeyCode(KeyEvent key) {
    	keyCode = key.getKeyCode();
    }
     
    private static class GameCycle implements ActionListener {
    	
        @Override
        public void actionPerformed(ActionEvent e) {
            doGameCycle();
        }
    }

    private static void doGameCycle() {
    	model.moveBall();
    	model.movePaddle();
        model.checkCollision();
    }
    
    public void setGameMenu(){
    	gameState = GameState.GAME_MENU;
    	System.out.println("Menu");
    }

    public void setPlaying() {
        gameState = GameState.PLAYING;
    }
    
    public void setChoosingDifficulty() {
    	gameState = GameState.DIFFICULTY;
    	System.out.println("Difficulty");
    }
    
    public void setGoingToGame() {
    	gameState = GameState.TO_GAME;
    }
    
    public void setDifficulty(int difficulty) {
    	switch (difficulty) {
    	case 0:
            TICKS_PER_SECOND = 1000 / 8;
            timer = new Timer(TICKS_PER_SECOND, new GameCycle());
            break;
        case 1:
            TICKS_PER_SECOND = 1000 / 15;
            timer = new Timer(TICKS_PER_SECOND, new GameCycle());
            break;
        case 2:
            TICKS_PER_SECOND = 1000 / 20;
            timer = new Timer(TICKS_PER_SECOND, new GameCycle());
            break;
        default:
            break;
    	}
    }
    
    public void setCredit() {
    	gameState = GameState.CREDIT;
    	System.out.println("Credit");
    }
}