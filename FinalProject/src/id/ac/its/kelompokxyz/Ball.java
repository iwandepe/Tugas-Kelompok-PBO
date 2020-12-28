package id.ac.its.kelompokxyz;

import javax.swing.ImageIcon;

public class Ball extends Sprite {

    private int xdir;
    private int ydir;
    private int weight;
    
    public Ball(int w) {
    	resetState();
        initBall(w);
    }
    
    public Ball(int x, int y, int w) {
    	this.x = x;
    	this.y = y;
    	initBall(w);
    }

    private void initBall(int w) {
    	
        xdir = 1;
        ydir = -1;
        weight = w;

        loadImage();
        getImageDimensions();
    }

    private void loadImage() {

        var ii = new ImageIcon("src/resources/ball.png");
        image = ii.getImage();
    }
	
	public void loadBigBallImage() {
		var ii = new ImageIcon("src/resources/bigball.png");
		image = ii.getImage();
		getImageDimensions();
	}

    void move() {

        x += xdir;
        y += ydir;

        if (x == 0) {

            setXDir(1);
        }

        if (x == Commons.WIDTH - imageWidth) {
//            System.out.println(imageWidth);
            setXDir(-1);
        }

        if (y == 0) {

            setYDir(1);
        }
    }

    private void resetState() {

        x = Commons.INIT_BALL_X;
        y = Commons.INIT_BALL_Y;
    }

    void setXDir(int x) {

        xdir = x;
    }

    void setYDir(int y) {

        ydir = y;
    }

    int getYDir() {

        return ydir;
    }
    
    int getXDir() {
    	return xdir;
    }
    
    void setWeight(int w) {
    	weight = w;
    }
    
    int getWeight() {
    	return weight;
    }
}
