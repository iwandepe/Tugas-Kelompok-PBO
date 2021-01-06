package id.ac.its.kelompokxyz.model;

import javax.swing.ImageIcon;
import id.ac.its.kelompokxyz.util.*;

public class Ball extends Sprite {

    private int xdir;
    private int ydir;
    private int weight;
    private int speed;
    private int ballType;
    
    public Ball(int w, int s, int ballType) {
    	resetState();
        initBall(w,s, ballType);
    }
    
    public Ball(int x, int y, int w, int s, int ballType) {
    	this.x = x;
    	this.y = y;
    	initBall(w,s,ballType);
    }

    private void initBall(int w, int s, int ballType) {
    	
        xdir = 1;
        ydir = -1;
        weight = w;
        speed = s;
    	this.ballType = ballType;

        loadImage();
        getImageDimensions();
    }

    public void loadImage() {
    	var ii = new ImageIcon();
    	if (ballType == 1) {
    		ii = new ImageIcon("src/resources/blackball.png");
    	}
    	else if (ballType == 11) { // big ball
    		ii = new ImageIcon("src/resources/bigball.png");
    	}
    	else {
    		ii = new ImageIcon("src/resources/brick.png");
    	}
    	image = ii.getImage();
    	getImageDimensions();
    }

    public void move() {

        x += xdir*speed;
        y += ydir*speed;

        if (x <= 0) {

            setXDir(1);
        }

        if (x >= Commons.WIDTH - imageWidth) {
//            System.out.println(imageWidth);
            setXDir(-1);
        }

        if (y <= 0) {

            setYDir(1);
        }
    }

    private void resetState() {

        x = Commons.INIT_BALL_X;
        y = Commons.INIT_BALL_Y;
    }

    public void setXDir(int x) {

        xdir = x;
    }

    public void setYDir(int y) {

        ydir = y;
    }

    public int getYDir() {

        return ydir;
    }
    
    public int getXDir() {
    	return xdir;
    }
    
    public void setWeight(int w) {
    	weight = w;
    }
    
    public int getWeight() {
    	return weight;
    }

	public int getBallType() {
		return ballType;
	}

	public void setBallType(int ballType) {
		this.ballType = ballType;
	}
    
    
}
