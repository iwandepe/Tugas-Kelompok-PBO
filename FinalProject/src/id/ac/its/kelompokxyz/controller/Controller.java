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

/**
 * Main Controller --- to control game cycle, game state, and determine program respond to input
 *  
 */

public class Controller{

	private static final long serialVersionUID = 1L;
    private static Timer timer;
    private static Model model = new Model();
	private static GameState gameState;
	int keyCodeInput;
    
    public static void main(String[] args) {
    	timer = new Timer(Commons.PERIOD, new GameCycle());
        timer.setInitialDelay(0);
    }
    
    private static class GameCycle implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		model.doGameCycle();
    	}
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
            switch (this.keyCodeInput) {
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
    	keyCodeInput = key.getKeyCode();
    }
    
    public void setGameMenu(){
    	gameState = GameState.GAME_MENU;
    }

    public void setPlaying() {
        gameState = GameState.PLAYING;
    }
    
    public void setChoosingDifficulty() {
    	gameState = GameState.DIFFICULTY;
    }
    
    public void setGoingToGame() {
    	gameState = GameState.TO_GAME;
    }
    
    public void setDifficulty(int difficulty) {
    	switch (difficulty) {
    	case 0:
            model.setGameSpeed(1);
            break;
        case 1:
        	model.setGameSpeed(2);
            break;
        case 2:
        	model.setGameSpeed(3);
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