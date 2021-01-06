package id.ac.its.kelompokxyz.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import id.ac.its.kelompokxyz.controller.Controller;

public class ViewListener implements KeyListener {

    boolean isGameOver;
    Controller controller = new Controller();

    public ViewListener() {
        isGameOver = false;
    }

    @Override
    public void keyPressed(KeyEvent key) {
        controller.respondToInput(key);
    }
    
    public void setPlaying() {
        controller.setPlaying();
    }
    
    public void setGameMenu() {
        controller.setGameMenu();
    }

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
