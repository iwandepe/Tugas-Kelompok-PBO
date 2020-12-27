package id.ac.its.kelompokxyz;

import javax.swing.ImageIcon;

public class Brick extends Sprite {

    private int weight;

	public Brick(int x, int y, int w) {
        
        initBrick(x, y, w);
    }
    
    private void initBrick(int x, int y, int w) {
        
        this.x = x;
        this.y = y;
        weight = w;

        loadImage();
        getImageDimensions();
    }

	private void loadImage() {
		var ii = new ImageIcon("src/resources/brick.png");
		image = ii.getImage();
    }
    
    void setWeight(int w) {
    	weight = w;
    }
    
    int getWeight() {
    	return weight;
    }
    
    void decreaseWeight(int value) {
    	weight -= value;
    }
}
