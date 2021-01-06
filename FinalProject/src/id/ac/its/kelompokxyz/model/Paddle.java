package id.ac.its.kelompokxyz.model;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import id.ac.its.kelompokxyz.util.*;

public class Paddle extends Sprite  {

    private int dx;
    private int speed;

    public Paddle(int s) {
        
        initPaddle(s);        
    }
    
    private void initPaddle(int s) {
    	speed = s;
    	
        loadImage();
        getImageDimensions();

        resetState();
    }
    
    private void loadImage() {
        
        var ii = new ImageIcon("src/resources/paddle.png");
        image = ii.getImage();        
    }    

    public void move() {

        x += dx*speed;

        if (x <= 0) {

            x = 0;
        }

        if (x >= Commons.WIDTH - imageWidth) {

            x = Commons.WIDTH - imageWidth;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 0;
        }
    }

    private void resetState() {

        x = Commons.INIT_PADDLE_X;
        y = Commons.INIT_PADDLE_Y;
    }

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
    
    
}
