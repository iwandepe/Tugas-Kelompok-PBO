package id.ac.its.kelompokxyz.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import id.ac.its.kelompokxyz.util.Commons;
import id.ac.its.kelompokxyz.util.GameState;
import id.ac.its.kelompokxyz.model.Model;

/**
 * Main Controller --- to control game cycle, game state, and determine program respond to input
 *  
 */

public class Controller{

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
        
        if (gameState == GameState.MAP) {
        	model.showMap();
        	return;
        }
        
//        if (gameState == GameState.PLAYING) {
//            switch (this.keyCodeInput) {
//                case KeyEvent.VK_LEFT:
//                    model.setMovePaddle(-1);
//                    System.out.println("kiri");
//                    break;
//                case KeyEvent.VK_RIGHT:
//                    model.setMovePaddle(1);
//                    System.out.println("kanan");
//                    break;
//                default:
//                    break;
//            }
//        }
    }
    
    public void keyPressed(KeyEvent e) {
    	if (gameState == GameState.PLAYING) {
	        int key = e.getKeyCode();
	
	        if (key == KeyEvent.VK_LEFT) {
	        	model.setMovePaddle(-1);
	            System.out.println("kiri");
	        }
	
	        if (key == KeyEvent.VK_RIGHT) {
	            model.setMovePaddle(1);
	            System.out.println("kanan");
	        }
    	}
    }
    
    public void keyReleased(KeyEvent e) {
    	if (gameState == GameState.PLAYING) {
	        int key = e.getKeyCode();
	
	        if (key == KeyEvent.VK_LEFT) {
	        	model.setMovePaddle(0);
	        	System.out.println("realesed");
	        }
	
	        if (key == KeyEvent.VK_RIGHT) {
	        	model.setMovePaddle(0);
	        	System.out.println("realesed");
	        }
    	}
    }
    
    public void setGameOver() {
    	timer.stop();
    	gameState = GameState.GAME_OVER;
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
    
    public void setPickMap() {
    	gameState = GameState.MAP;
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
    
    public void setCurrentMap(int mapCode) {
    	model.setMapCode(mapCode);
    }
    
    public void setCredit() {
    	gameState = GameState.CREDIT;
    	System.out.println("Credit");
    }
    
    public void updateScore() {
    	model.view.updateScore();
    }
}