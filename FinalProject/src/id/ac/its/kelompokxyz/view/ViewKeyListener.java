package id.ac.its.kelompokxyz.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ViewKeyListener extends ViewListener implements KeyListener {
	
	@Override
    public void keyPressed(KeyEvent key) {
		controller.setKeyCode(key);
        controller.respondToInput();
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
