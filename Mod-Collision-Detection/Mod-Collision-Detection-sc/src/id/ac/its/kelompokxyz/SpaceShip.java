package id.ac.its.kelompokxyz;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Sprite {
	
	private int dx;
    private int dy;
    private List<Missile> missiles;
    
    public SpaceShip(int x, int y) {
        super(x, y);

        initCraft();
    }
    
    private void initCraft() {
        missiles = new ArrayList<>();
        loadImage("resources/spaceship.png");
        getImageDimensions();
    }
    
    public void move() {
        x = dx;
        y = dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
        
        if (x > 1250) {
            x = 1250;
        }
        
        if (y > 700) {
            y = 700;
        }
    }

    public List<Missile> getMissiles() {
        return missiles;
    }
    
    public void mouseMoved(MouseEvent e) {
    	dx = e.getX();
    	dy = e.getY();
    }

    public void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
    }
    
    // click for fire    
    public void mouseClicked(MouseEvent e) {
    	fire();
    }
    
    // space for fire
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }
    }
    
}