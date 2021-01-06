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
	private static Timer timer;
    private static Model model = new Model();
	private GameState gameState;
    
    public static void main(String[] args) {
    	timer = new Timer(Commons.PERIOD, new GameCycle());
        timer.start();
//        System.out.println("Here");
    }
    
    public void respondToInput(KeyEvent key) {
        int keyCode = key.getKeyCode();

        if (gameState == GameState.GAME_MENU) {
//            model.showMenu();
            return;
        }
        
        if (gameState == GameState.PLAYING) {
            
            switch (key.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    model.movePaddle(-1);
                    break;
                case KeyEvent.VK_RIGHT:
                    model.movePaddle(1);
                    break;
                default:
                    break;
            }
        }
    }
     
    private static class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            doGameCycle();
        }
    }

    private static void doGameCycle() {
    	
    	for (Ball ball: model.getBalls()) {
    		ball.move();
    	}
        model.getPaddle().move();
        model.checkCollision();
    }
    
    public void setGameMenu(){
    	gameState = GameState.GAME_MENU;
    }

    public void setPlaying() {
        gameState = GameState.PLAYING;
    }
}