package id.ac.its.kelompokxyz.model;

import javax.swing.ImageIcon;

public class Brick extends Sprite {

    private int weight;
    private int brickType;

	public Brick(int x, int y, int w, int brickType) {
        
        initBrick(x, y, w, brickType);
    }
    
    private void initBrick(int x, int y, int w, int brickType) {
        
        this.x = x;
        this.y = y;
        weight = w;
        this.brickType = brickType;

        loadImage();
    }

	private void loadImage() {
		var ii = new ImageIcon();
		if (brickType == 1) {
			ii = new ImageIcon("src/resources/brick.png");
		}
		else if (brickType == 2) {
			ii = new ImageIcon("src/resources/brick2.png");
		}
		else if (brickType == 3){
			ii = new ImageIcon("src/resources/brick3.png");
		}
		else if (brickType == 11) {
			ii = new ImageIcon("src/resources/treasureManyBall.png");
		}
		else if (brickType == 12) {
			ii = new ImageIcon("src/resources/treasureBigBall.png");
		}
		image = ii.getImage();
		getImageDimensions();
    }
    
    void setWeight(int w) {
    	weight = w;
    }
    
    public int getWeight() {
    	return weight;
    }
    
    public void decreaseWeight(int value) {
    	weight -= value;
    }

	public int getBrickType() {
		return brickType;
	}

	public void setBrickType(int brickType) {
		this.brickType = brickType;
	}
    
    
}
